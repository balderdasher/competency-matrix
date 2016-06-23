package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter5;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁
 * 在计时测试中使用CountDownLatch来启动和停止线程
 *
 * @author huxiong
 * @date 2016/06/13 11:15
 */
public class TestHarness {

    public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);//起始门计数器的初始值为1
        final CountDownLatch endGate = new CountDownLatch(nThreads);//结束们计数器的初始值为工作线程的数量

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        //每个工作线程首先要做的就是在起始门上等待，从而确保所有线程都就绪后才开始执行
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            //每个工作线程最后要做的事情就是调用结束门的countDown方法减1，这能使主线程高效地等待直到所有工作线程都执行完成，因此可以统计消耗的时间
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable task = new Runnable() {
            int i;

            @Override
            public void run() {
                while (i < 100) {
                    i++;
                    System.out.println(Thread.currentThread().getId() + "--" + i);
                }
            }
        };
        long takeTime = timeTasks(6, task);
        System.out.println(takeTime);
    }
}
