package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义线程，并定制线程的其他行为，包括：为线程指定名字、
 * 设置自定义的UncaughtExceptionHandler向Logger中写入信息、
 * 维护一些统计信息（包括有多少线程被创建和销毁）、
 * 以及在线程被创建或终止时把调试信息写入日志
 *
 * @author huxiong
 * @date 2016/06/15 16:52
 */
public class MyAppThread extends Thread {
    public static final String DEFAULT_NAME = "MyAppThread";
    private static volatile boolean debugLIfecycle = false;
    private static final AtomicInteger created = new AtomicInteger();
    private static final AtomicInteger alive = new AtomicInteger();
    private static final Logger log = LoggerFactory.getLogger(MyAppThread.class);

    public MyAppThread(Runnable r) {
        this(r, DEFAULT_NAME);
    }

    public MyAppThread(Runnable runnable, String poolName) {
        // 设置线程名字为线程池名称加上一个不断增加的数字
        super(runnable, poolName + "-" + created.incrementAndGet());
        // 自定义UncaughtExceptionHandler向Logger中写入信息
        setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                log.info("UNCAUGHT in thread " + t.getName(), e);
            }
        });
    }

    @Override
    public void run() {
        // 复制debug标志以确保一致的值
        boolean debug = debugLIfecycle;
        if (debug) {
            log.info("Created " + getName());
        }
        try {
            alive.incrementAndGet();
            super.run();
        } finally {
            alive.decrementAndGet();
            if (debug) {
                log.info("Exiting " + getName());
            }
        }
    }

    public static int getThreadsCreated() {
        return created.get();
    }

    public static int getThreadsAlive() {
        return alive.get();
    }

    public static boolean getDebug() {
        return debugLIfecycle;
    }

    public static void setDebug(boolean b) {
        debugLIfecycle = b;
    }
}
