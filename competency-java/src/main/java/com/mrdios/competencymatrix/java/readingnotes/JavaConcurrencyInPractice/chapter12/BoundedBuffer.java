package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter12;

import java.util.concurrent.Semaphore;

/**
 * 基于信号量的有界缓存
 *
 * @author huxiong
 * @date 2016/06/24 11:11
 */
public class BoundedBuffer<E> {

    /**
     * 可以从缓存中删除的元素个数
     */
    private final Semaphore availableItems;

    /**
     * 可以插入到缓存中的元素个数
     */
    private final Semaphore availableSpaces;

    /**
     * 缓存中的元素
     */
    private final E[] items;

    /**
     * 插入元素的位置
     */
    private int putPosition = 0;

    /**
     * 取出元素的位置
     */
    private int takePosition = 0;

    public BoundedBuffer(int capacity) {
        availableItems = new Semaphore(0);
        availableSpaces = new Semaphore(capacity);
        items = (E[]) new Object[capacity];
    }

    /**
     * 缓存是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return availableItems.availablePermits() == 0;
    }

    /**
     * 缓存是否为null
     *
     * @return
     */
    public boolean isNull() {
        return availableSpaces.availablePermits() == 0;
    }

    /**
     * 插入元素
     *
     * @param e
     * @throws InterruptedException
     */
    public void put(E e) throws InterruptedException {
        availableSpaces.acquire();
        doInsert(e);
        availableItems.release();
    }

    /**
     * 删除元素
     *
     * @return
     * @throws InterruptedException
     */
    public E take() throws InterruptedException {
        availableItems.acquire();
        E item = doExtract();
        availableSpaces.release();
        return item;
    }

    /**
     * 缓存中插入元素
     *
     * @param e
     */
    private synchronized void doInsert(E e) {
        int i = putPosition;
        items[i] = e;
        putPosition = (++i == items.length) ? 0 : 1;
    }

    /**
     * 从缓存中取出元素
     *
     * @return
     */
    private synchronized E doExtract() {
        int i = takePosition;
        E e = items[i]; // 去除元素
        items[i] = null; // 从缓存中删除元素
        takePosition = (++i == items.length) ? 0 : 1;
        return e;
    }
}
