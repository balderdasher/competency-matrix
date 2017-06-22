package com.mrdios.competencymatrix.concurrency.chapter7_13atomic_classes;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 原子方式更新数组
 *
 * @author MrDios
 * @date 2017-06-22
 */
public class AtomicIntegerArrayTest {
    static final int[] value = {1, 2};
    static final AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
