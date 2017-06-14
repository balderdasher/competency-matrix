package com.mrdios.competencymatrix.concurrency.chapter4_ConcurrentFoundation;

import java.util.concurrent.TimeUnit;

/**
 * 通过标识位或中断操作安全地终止线程
 *
 * @author MrDios
 * @date 2017-06-13
 */
public class Shutdown {

    public static void main(String[] args) throws InterruptedException {
        Runner r1 = new Runner();
        Thread countThread = new Thread(r1, "CountThread");
        countThread.start();
        // 睡眠1s，main线程对CountThread进行中断，使CountThread能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner r2 = new Runner();
        countThread = new Thread(r2, "CountThread");
        countThread.start();
        // 睡眠1s，main线程对Runner r2进行取消，使CountThread能够感知on为false而结束
        TimeUnit.SECONDS.sleep(1);
        r2.cancel();
    }

    private static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true; // 标识位

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);
        }

        public void cancel() {
            on = false;
        }
    }
}
