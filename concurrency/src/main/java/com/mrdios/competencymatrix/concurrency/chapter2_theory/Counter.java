package com.mrdios.competencymatrix.concurrency.chapter2_theory;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用循环CAS实现原子操作
 *
 * @author MrDios
 * @date 2017-06-02
 */
public class Counter {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int i = 0;

    // 使用CAS实现的线程安全计数器
    private void safeCount() {
        for (; ; ) {
            int i = atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(i, ++i);
            if (suc) {
                break;
            }
        }
    }

    // 非线程安全计数器
    private void count() {
        i++;
    }

    public static void main(String[] args) {
        final Counter cas = new Counter();
        List<Thread> ts = new ArrayList<>(600);
        StopWatch watch = new StopWatch();
        watch.start();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            ts.add(t);
        }
        for (Thread t : ts) {
            t.start();
        }
        // 等待所有线程执行完成
        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        watch.stop();
        long time = watch.getTotalTimeMillis();
        System.out.println(cas.i);
        System.out.println(cas.atomicInteger.get());
        System.out.println(time + "ms");
    }
}
