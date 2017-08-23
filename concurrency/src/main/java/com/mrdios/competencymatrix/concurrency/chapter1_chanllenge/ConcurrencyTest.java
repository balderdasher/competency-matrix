package com.mrdios.competencymatrix.concurrency.chapter1_chanllenge;

import com.mrdios.competencymatrix.concurrency.util.StopWatch;

/**
 * 多线程就一定快吗？
 *
 * @author MrDios
 * @date 2017-06-01
 */
public class ConcurrencyTest {

    // 并发
    private static void concurrency(final long count) throws InterruptedException {
        StopWatch watch = new StopWatch("concurrency");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        double time = watch.elapsedTime();
        thread.join();
        System.out.println("concurrency :" + time + "ms,b=" + b);
    }

    // 串行
    private static void serial(long count) {
        StopWatch watch = new StopWatch("serial");
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        double time = watch.elapsedTime();
        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
    }

    public static void main(String[] args) throws InterruptedException {
        long count = 100000000L;
        if (args.length != 0) {
            count = Long.valueOf(args[0]);
        }
        concurrency(count);
        serial(count);
    }
}
