package com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 先进先出队列
 *
 * @author huxiong
 * @date 2017-03-31 10:54
 */
public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Create an empty queue
     */
    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * is the queue empty?
     *
     * @return true if queue is empty otherwise false
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Return the number of emelments of in the queue
     *
     * @return the number of emelments of in the queue
     */
    public int size() {
        return size;
    }

    /**
     * Add an item
     *
     * @param item an element
     */
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }


    /**
     * 删除最近添加的元素
     *
     * @return item
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node node = first;
        first = first.next;
        size--;
        return node.item;
    }

    /**
     * 删除队列中第k个元素(练习题实现)
     *
     * @param k delete index，begin from 1
     * @return this
     */
    public Queue<Item> delete(int k) {
        if (k <= 0 || k > size) {
            throw new IllegalArgumentException("delete index must in[1,size]");
        } else if (k == 1) {
            dequeue();
            return this;
        }

        int n = 1;
        Node current = first;
        while (n < k) {
            if (n == k - 1) {
                if (current.next.next != null) {
                    current.next = current.next.next;
                } else {
                    current.next = null;
                }
            }
            current = current.next;
            n++;
        }
        size--;
        return this;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current;

        public ListIterator() {
            this.current = first;
        }

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
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : this) {
            sb.append(item);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        for (int i = 0; i < 5; i++) {
            String s = "str" + (i + 1);
            System.out.println("Enqueuing " + s);
            queue.enqueue(s);
        }
        System.out.println("size of queue = " + queue.size());
        for (int i = 0; i < 5; i++) {
            System.out.println("Dequeuing " + queue.dequeue());
        }
        System.out.println("size of queue = " + queue.size());
    }
}
