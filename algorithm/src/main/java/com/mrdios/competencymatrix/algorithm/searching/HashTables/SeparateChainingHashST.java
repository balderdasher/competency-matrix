package com.mrdios.competencymatrix.algorithm.searching.HashTables;

import com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.queue.Queue;
import com.mrdios.competencymatrix.algorithm.searching.SymbolTables.SequentialSearchST;

/**
 * 基于拉链法的散列表
 *
 * @author huxiong
 * @date 2017-04-25 15:22
 */
public class SeparateChainingHashST<Key, Value> {
    private int n;                               // 键值对总数
    private int m;                               // 散列表的大小
    private SequentialSearchST<Key, Value>[] st; // 存放链表对象的数组

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int m) {
        // 创建m条链表
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            st[i] = new SequentialSearchST();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < m; i++) {
            size += st[i].size();
        }
        return size;
    }

    /**
     * is contains the given key?
     *
     * @param key the given key
     * @return if the st contains the given key
     */
    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is null.");
        }
        return st[hash(key)].contanis(key);
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null.");
        }
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("argument to put() is null.");
        }
        st[hash(key)].put(key, value);
    }

    /**
     * 返回所有键
     *
     * @return all keys
     */
    public Iterable<Key> keys() {
        Queue<Key> keys = new Queue<>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                keys.enqueue(key);
            }
        }
        return keys;
    }

    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>();
        for (int i = 0; i < 10; i++) {
            st.put("str" + (i + 1), i + 1);
        }

        System.out.println("st.size is " + st.size());
        System.out.println("st.contains(str1) is " + st.contains("str1"));

        System.out.print("st's keys: ");
        for (String key : st.keys()) {
            System.out.print(key + " ");
        }
    }
}
