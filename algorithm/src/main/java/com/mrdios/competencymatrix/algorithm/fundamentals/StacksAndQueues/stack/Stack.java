package com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 一个后进先出的栈-单链表实现
 *
 * @author huxiong
 * @date 2017-03-31 15:20
 */
public class Stack<Item> implements Iterable<Item> {

    private Node top; // 栈顶元素
    private int size; // 元素数量

    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * 初始化一个空栈
     */
    public Stack() {
        top = null;
        size = 0;
    }

    /**
     * 栈是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回栈中元素数量
     *
     * @return 元素数量
     */
    public int size() {
        return size;
    }

    /**
     * 压入栈
     *
     * @param item 压入元素
     */
    public void push(Item item) {
        Node oldTop = top;
        top = new Node();
        top.item = item;
        top.next = oldTop;
        size++;
    }

    /**
     * 弹出栈
     *
     * @return 栈顶元素 top
     */
    public Item pop() {
        Node oldTop = top;
        top = top.next;
        size--;
        return oldTop.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = top;

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

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            String s = "str" + (i + 1);
            System.out.println("Stack push " + s);
            stack.push(s);
        }
        for (String s : stack) {
            System.out.print(s + "\t");
        }
        System.out.println("size of stack = " + stack.size());
        for (int i = 0; i < 5; i++) {
            System.out.println("Stack pop " + stack.pop());
        }
        System.out.println("size of stack = " + stack.size());
    }
}
