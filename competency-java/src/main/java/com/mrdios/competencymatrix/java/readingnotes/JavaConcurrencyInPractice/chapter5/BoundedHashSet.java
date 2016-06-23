package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter5;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 使用Semaphore(信号量)为容器设置边界
 *
 * @author huxiong
 * @date 2016/06/13 12:51
 */
public class BoundedHashSet<T> {
    private final Set<T> set;
    private final Semaphore sem;

    /**
     * 构造函数指定容器的边界，底层的set实现并不知道关于边界的任何信息
     *
     * @param bound
     */
    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        sem = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        //获得一个许可
        sem.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            //添加不成功则释放许可
            if (!wasAdded) {
                sem.release();
            }
        }
    }

    public boolean remove(Object o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved) {
            //释放一个许可
            sem.release();
        }
        return wasRemoved;
    }
}
