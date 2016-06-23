package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter1;

import javax.annotation.Generated;

/**
 * 一个线程安全的数值序列生成器，加了同步操作
 *
 * @author huxiong
 * @date 2016/05/10 11:49
 */
public class SafeSequence {
    //注解是同步策略
    @Generated("this")
    private int value;

    public synchronized int getValue() {
        return value++;
    }
}
