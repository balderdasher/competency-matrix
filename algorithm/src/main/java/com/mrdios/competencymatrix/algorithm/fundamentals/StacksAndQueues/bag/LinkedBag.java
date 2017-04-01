package com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author huxiong
 * @date 2017-03-31 9:51
 */
public class LinkedBag<Item> implements Iterable<Item> {
    private Node first;
    private int size;

    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Initializes an empty bag
     */
    public LinkedBag() {
        this.first = null;
        this.size = 0;
    }

    /**
     * is the bag empty?
     *
     * @return true if bag is empty otherwise false
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * return the number of elements in the bag
     *
     * @return the number of elements in the bag
     */
    public int size() {
        return this.size;
    }

    /**
     * Add an element into the bag
     *
     * @param item an element
     */
    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
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
            return this.current != null;
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

    public static void main(String[] args) {
        LinkedBag<String> bag = new LinkedBag<>();
        for (int i = 0; i < 10; i++) {
            bag.add("Str" + (i + 1));
        }
        System.out.println("size of bag = " + bag.size());
        Iterator<String> it = bag.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + "\t");
        }
    }
}
