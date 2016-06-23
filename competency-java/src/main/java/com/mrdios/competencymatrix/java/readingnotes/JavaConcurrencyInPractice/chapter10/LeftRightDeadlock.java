package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter10;

/**
 * 简单的锁顺序死锁
 * 容易发生死锁：如果一个线程调用了leftRight，而另一个线程调用了rightLeft,并且这两个线程
 * 的操作是交错执行，那么他们会发生死锁
 *
 * @author huxiong
 * @date 2016/06/16 17:19
 */
public class LeftRightDeadlock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                // do something
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                // do something
            }
        }
    }
}
