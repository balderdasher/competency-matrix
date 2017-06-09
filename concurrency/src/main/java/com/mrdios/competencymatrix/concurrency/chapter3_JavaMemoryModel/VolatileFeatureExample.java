package com.mrdios.competencymatrix.concurrency.chapter3_JavaMemoryModel;

/**
 * @author MrDios
 * @date 2017-06-09
 */
public class VolatileFeatureExample {
    volatile long v = 0L;           // 使用volatile声明64位的long型变量
    long v1 = 0L;                   // 不使用volatile声明时需要加同步

    public void set(long l) {
        v = l;                      // 单个volatile变量的写操作
    }

    public void getAndIncrement() {
        v++;                        // 复合（多个）volatile变量的读/写
    }

    public long get() {
        return v;                   // 单个volatile量的读操作
    }

    // 对单个普通变量的写用同一个锁同步
    public synchronized void setV1(long l) {
        v1 = l;
    }

    public void getAndIncrementV1() {// 普通方法调用
        long temp = get();          // 调用已同步的方法
        temp += 1L;                 // 普通写操作
        setV1(temp);                // 调用已同步的方法
    }

    public synchronized long getV1() {
        return v1;
    }
}
