package com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 能够动态调整数组大小的栈实现
 *
 * @author huxiong
 * @date 2017-03-31 16:50
 */
public class ResizingArrayStack<E> implements Iterable<E> {
    private E[] items;   // 栈中元素
    private int size;       // 元素数量

    /**
     * 创建一个空栈
     */
    public ResizingArrayStack() {
        this.items = (E[]) new Object[1];
        this.size = 0;
    }

    /**
     * 栈是否为空
     *
     * @return true if stack is empty otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回栈中元素数量
     *
     * @return number of items on stack
     */
    public int size() {
        return size;
    }

    // 数组扩容操作
    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        // can be replaced with "System.arraycopy(items, 0, temp, 0, size);"
        for (int i = 0; i < size; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    /**
     * 将元素压入栈顶
     *
     * @param item item
     */
    public void push(E item) {
        if (size == items.length) resize(2 * items.length);
        items[size++] = item;
    }

    /**
     * 从栈顶删除元素并返回最近压入栈的元素
     *
     * @return 删除的元素
     */
    public E pop() {
        E item = items[--size];
        items[size] = null;  // 删除游离对象

        /*
         元素删除后若数组的长度太大应该将其长度减半，检测条件是栈的大小
         是否小于数组的四分之一，数组长度减半后，它的状态为半满，以便下
         次改变数组大小之前仍然可以进行多次压栈和弹栈操作，此实现中栈永
         远不会溢出，使用率也永远不会低于1/4（除非栈为空，此时数组大小为1）
        */
        if (size > 0 && size == items.length / 4) resize(items.length / 2);
        return item;
    }

    @Override
    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<E> {
        private int currentIndex = size - 1;

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Stack underflow");
            }
            return items[currentIndex--];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        for (int i = 0; i < 5; i++) {
            String s = "str" + (i + 1);
            System.out.println("ResizingArrayStack push " + s);
            stack.push(s);
        }
        for (String s : stack) {
            System.out.print(s + "\t");
        }
        System.out.println("size of stack = " + stack.size());
        for (int i = 0; i < 5; i++) {
            System.out.println("ResizingArrayStack pop " + stack.pop());
        }
        System.out.println("size of stack = " + stack.size());
    }
}
