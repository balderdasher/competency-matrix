package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter1;

/**
 * 一个线程不安全的数值序列生成器，当两个线程同时执行读操作时就会造成value++的结果相同
 * @author huxiong
 * @date 2016/05/10 11:11
 */
public class UnsafeSequence {
    private int value;

    /** 返回一个唯一的数值 */
    public int getNext(){
        return value++;
    }
}
