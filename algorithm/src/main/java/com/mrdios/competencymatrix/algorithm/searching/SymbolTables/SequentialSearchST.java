package com.mrdios.competencymatrix.algorithm.searching.SymbolTables;

/**
 * 顺序查找(基于无序链表)
 *
 * @author huxiong
 * @date 2017-04-13 10:20
 */
public class SequentialSearchST<Key, Value> {
    private Node first;  // 链表首结点
    private int n;       // 键值对数量

    // 链表结点类
    private class Node {
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 返回链表中的键值对数量
     *
     * @return number of key-value pairs
     */
    public int size() {
        return n;
    }

    /**
     * 链表是否为空
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 查找给定的键，找到则更新值，否则新建结点
     *
     * @param key   key
     * @param value value
     */
    public void put(Key key, Value value) {
        // 命中？更新旧值
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        // 未命中？新建结点
        first = new Node(key, value, first);
        n++;
    }

    /**
     * 查找给定的键，返回相关联的值
     *
     * @param key search key
     * @return the value for the key
     */
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value; // 命中
            }
        }
        return null;    // 未命中
    }
}
