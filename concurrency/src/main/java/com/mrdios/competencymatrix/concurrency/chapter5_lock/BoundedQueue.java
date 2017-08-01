package com.mrdios.competencymatrix.concurrency.chapter5_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition接口实现的有界队列
 *
 * @author MrDios
 * @date 2017-06-20co
 */
public class BoundedQueue<E> {
    private E[] items;      // 队列中的元素
    private int addIndex;   // 插入元素的下标
    private int removeIndex;// 删除元素的下标
    private int count;      // 队列中的元素数量

    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();   // 队列不空的条件
    private Condition notFull = lock.newCondition();    // 队列不满的条件

    public BoundedQueue(int size) {
        items = (E[]) new Object[size];
    }


    /**
     * 添加元素：如果数组满，则添加线程进入等待状态，直到有“空位”
     *
     * @param e element
     * @throws InterruptedException
     */
    public void add(E e) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[addIndex] = e;
            if (++addIndex == items.length) {
                addIndex = 0;
            }
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 由头部删除一个元素，如果数组为空，则删除线程进入等待状态，知道有新元素被添加
     *
     * @return the element removed
     * @throws InterruptedException
     */
    public E remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            E x = items[removeIndex];
            if (++removeIndex == items.length) {
                removeIndex = 0;
            }
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
