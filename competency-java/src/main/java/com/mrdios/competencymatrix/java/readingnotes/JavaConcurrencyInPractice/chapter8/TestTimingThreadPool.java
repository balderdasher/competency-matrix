package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter8;

import org.junit.Test;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huxiong
 * @date 2016/06/15 17:31
 */
public class TestTimingThreadPool {

    @Test
    public void testTimingThreadPool() {
        ThreadPoolExecutor exec = new TimingThreadPool(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        MyAppThread myAppThread = new MyAppThread(new Runnable() {
            @Override
            public void run() {
                int n = 0;
                for (int i = 0; i < 10; i++) {
                    n++;
                }
                System.err.println(n);
            }
        }, "TimingThreadPool");
        MyAppThread.setDebug(true);
        exec.execute(myAppThread);
    }

    public static void main(String[] args) {
        TestTimingThreadPool testTimingThreadPool = new TestTimingThreadPool();
        testTimingThreadPool.testTimingThreadPool();
    }
}
