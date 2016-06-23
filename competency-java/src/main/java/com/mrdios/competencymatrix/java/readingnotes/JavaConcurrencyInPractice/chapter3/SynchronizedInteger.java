package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter3;

import javax.annotation.Generated;

/**
 * 线程安全的可变整数类
 *
 * @author huxiong
 * @date 2016/05/11 17:14
 */
public class SynchronizedInteger {
    @Generated("this")
    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}
