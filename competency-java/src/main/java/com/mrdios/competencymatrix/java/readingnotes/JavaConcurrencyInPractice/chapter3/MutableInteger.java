package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter3;

/**
 * 非线程安全的可变整数类
 * @author huxiong
 * @date 2016/05/11 17:12
 */
public class MutableInteger {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
