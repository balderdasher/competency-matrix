package com.mrdios.competencymatrix.algorithm.searching.SymbolTables;

import com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.queue.Queue;

/**
 * 有序数组中的二分查找
 *
 * @author huxiong
 * @date 2017-04-13 13:53
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int n;
    // default capacity
    private static final int INIT_CAPACITY = 2;

    public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    /**
     * 返回符号表中键值对数量
     *
     * @return
     */
    public int size() {
        return n;
    }

    /**
     * 符号表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 符号表中是否包含某个key
     *
     * @param key given key
     * @return
     */
    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }

    /**
     * 向符号表中插入键值对
     *
     * @param key key
     * @param val value
     */
    public void put(Key key, Value val) {
        // 查找键
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            vals[i] = val;  // 找到则更新
            return;
        }
        // resize?
        if (n == keys.length) {
            resize(2 * keys.length);
        }
        // 把更大的键向右移动一格为key腾出位置
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        // 键和值放入合适的位置
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    /**
     * 从符号表中获取key对应的值
     *
     * @param key key
     * @return value for the given key
     */
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    /**
     * 删除键值对
     *
     * @param key
     */
    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (isEmpty()) {
            return;
        }
        int i = rank(key);
        // 不在表中？
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }
        // 把待删除key右边的key向左移一格
        for (int j = i; j < n; j++) {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }
        n--;
        // 回收游离对象
        keys[n] = null;
        keys[n] = null;

        // 收缩容量
        if (n > 0 && n == keys.length / 4) {
            resize(keys.length / 2);
        }
    }

    /**
     * 返回最小的键
     *
     * @return
     */
    public Key min() {
        if (isEmpty()) {
            throw new IllegalStateException("the symbol table is empty");
        }
        return keys[0];
    }

    /**
     * 返回最小的键
     *
     * @return
     */
    public Key max() {
        if (isEmpty()) {
            throw new IllegalStateException("the symbol table is empty");
        }
        return keys[n - 1];
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    /**
     * Returns all keys in this symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param lo minimum endpoint
     * @param hi maximum endpoint
     * @return all keys in this symbol table between {@code lo}
     * (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *                                  is {@code null}
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue<>();
        if (lo.compareTo(hi) > 0) return queue;
        for (int i = rank(lo); i < rank(hi); i++)
            queue.enqueue(keys[i]);
        if (contains(hi)) queue.enqueue(keys[rank(hi)]);
        return queue;
    }

    /**
     * 二分查找算法
     *
     * @param key
     * @return
     */
    private int rank(Key key) {
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    /**
     * 数组扩容操作
     *
     * @param newCapacity 新的容量大小
     */
    private void resize(int newCapacity) {
        if (newCapacity < n) {
            throw new IllegalArgumentException("argument to resize() is too small");
        }
        Key[] tmpKeys = (Key[]) new Comparable[newCapacity];
        Value[] tmpVals = (Value[]) new Object[newCapacity];
        for (int i = 0; i < n; i++) {
            tmpKeys[i] = keys[i];
            tmpVals[i] = vals[i];
        }
        keys = tmpKeys;
        vals = tmpVals;
    }

    public static void main(String[] args) {
        BinarySearchST<Character, Integer> st = new BinarySearchST<>();
        String s = "SEARCHEXAMPLE";
        for (int i = 0; i < s.length() - 1; i++) {
            st.put(s.charAt(i), i);
        }
        for (Character key : st.keys()) {
            System.out.println(key + " " + st.get(key));
        }
    }
}
