package com.mrdios.competencymatrix.concurrency.chapter4_ConcurrentFoundation;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal的使用
 *
 * @author MrDios
 * @date 2017-06-14
 */
public class Profiler {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        // 第一次get()方法调用时会进行初始化（如果set方法没有调用），每个线程会调用一次
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    // 返回从begin()方法调用开始到end()方法被调用时的时间差
    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " millis");
    }
}
