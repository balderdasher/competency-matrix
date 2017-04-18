package com.mrdios.competencymatrix.algorithm.searching.BinarySearchTrees;

import com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.queue.Queue;

import java.util.NoSuchElementException;

/**
 * 二叉查找树
 *
 * @author huxiong
 * @date 2017-04-14 9:57
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;          // 二叉查找树的根结点

    private class Node {
        private Key key;        // 键
        private Value val;      // 值
        private Node left;      // 左链接
        private Node right;     // 右链接
        private int n;          // 以该结点为根的子树中的结点总数

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }

    /**
     * 符号表是否为空
     *
     * @return 符号表是否为空
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 计算二叉查找树的结点总数-键的总数
     *
     * @return 二叉查找树中的键总数
     */
    public int size() {
        return size(root);
    }

    // 获得结点x的子树结点数
    private int size(Node x) {
        return x == null ? 0 : x.n;
    }

    /**
     * 获取键值
     *
     * @param key 搜索键
     * @return 键对应的值
     */
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * 在以x为根结点的子树中查找并返回key对应的值
     *
     * @param x   子树的根结点
     * @param key 查找键
     * @return 命中返回key对应的value，否则返回null
     */
    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        // 比较key与当前子树根结点的key的大小决定在左还是右子树中搜索
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.val;
        }
    }

    /**
     * 插入键值对
     *
     * @param key 键
     * @param val 值
     */
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        // 如果key存在于以x为根结点的子树中则更新它的值
        // 否则将以key和val为键值对的新结点插入到该子树中
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 删除结点
     *
     * @param key 键
     * @return 被删除结点的value
     */
    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("called delete() with a null key");
        }
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node t = x;
            x = min(t.right);   // 后继结点为min(t.right)
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 删除最小的键
     */
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("symbol table underflow");
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 删除最大键
     */
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow");
        }
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 最小键
     *
     * @return 树中最小的键
     */
    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        // 如果根结点的左链接为空，最小键就是根结点
        // 否则为左子树中的最小键
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }

    /**
     * 最大键
     *
     * @return 树中最大的键
     */
    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        // 如果根结点的右链接为空，最大键就是根结点
        // 否则为右子树中的最大键
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }

    /**
     * 向下取整：找出小于等于给定key的最大键
     *
     * @return
     */
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        // key小于根结点的key时在左子树
        if (cmp < 0) {
            return floor(x.left, key);
        }
        // key大于根结点的key并且当根结点右子树中存在小于等于key的结点时会在右子树中
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            // 否则为根结点key
            return x;
        }
    }

    /**
     * 向上取整：找出大于等于给定key的最小键
     *
     * @param key
     * @return
     */
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        // key大于根结点的key时在右子树
        if (cmp > 0) {
            return ceiling(x.right, key);
        }
        // key小于根结点的key并且当根结点左子树中存在大于等于key的结点时会在左子树中
        Node t = ceiling(x.left, key);
        if (t != null) {
            return t;
        } else {
            // 否则即为根结点的key
            return x;
        }
    }

    /**
     * 返回符号表中第k小的键
     *
     * @param k 排名
     * @return 符号表中第k小的键
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("called select() with invalid argument: " + k);
        }
        Node x = select(root, k);
        return x.key;
    }

    // 返回排名为k的结点
    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }

    /**
     * 排名：返回符号表中小于给定键的键总数
     *
     * @param key 给定key
     * @return 符号表中小于给定键的键总数
     */
    public int rank(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to rank() is null");
        }
        return rank(root, key);
    }

    // 返回以x为根结点的子树中小于x.key的键的数量
    private int rank(Node x, Key key) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(x.left, key);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(x.right, key);
        } else {
            return size(x.left);
        }
    }

    /**
     * 范围查找
     *
     * @return
     */
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    public static void main(String[] args) {
        BST<Character, Integer> st = new BST();
        String s = "SEARCHEXAMPLE";
        for (int i = 0; i < s.length() - 1; i++) {
            st.put(s.charAt(i), i);
        }
        for (Character key : st.keys()) {
            System.out.println(key + " " + st.get(key));
        }
        System.out.println("min: " + st.min());
        System.out.println("max: " + st.max());
        System.out.println("select(3): " + st.select(3));
        System.out.println("rank of L: " + st.rank('L'));
        System.out.println("floor of L: " + st.floor('L'));
        st.delete('R');
        for (Character key : st.keys()) {
            System.out.println(key + " " + st.get(key));
        }
    }
}
