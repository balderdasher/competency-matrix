package com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author huxiong
 * @date 2017-03-30 19:11
 */
public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first; // 背包开始节点
    private int size;   // 背包中的元素数量

    // 链表结构帮助类
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * create an empty bag
     */
    public Bag() {
        this.first = null;
        this.size = 0;
    }

    /**
     * add an item
     *
     * @param item
     */
    public void add(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    /**
     * is the bag empty?
     *
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * number of items in the bag
     *
     * @return
     */
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node<Item> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Item item = current.item;
                current = current.next;
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        for (int i = 0; i < 10; i++) {
            bag.add("Str" + (i + 1));
        }
        System.out.println("the bag size: " + bag.size());
        for (String str : bag) {
            System.out.print(str + "\t");
        }
    }

}
