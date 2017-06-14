package com.mrdios.competencymatrix.concurrency.chapter4_ConcurrentFoundation;

import com.mrdios.competencymatrix.concurrency.util.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * 理解中断
 *
 * @author MrDios
 * @date 2017-06-13
 */
public class Interrupted {
    public static void main(String[] args) throws Exception {
        // sleepThread不停地尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);

        // busyThread不停地运行
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);

        // 启动线程
        sleepThread.start();
        busyThread.start();

        // 休眠5s，让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(5);

        // 中断线程
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        // 防止sleepThread和busyThread立刻退出
        SleepUtils.second(2);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                // 当抛出中断异常时会清除线程的中断状态：此时interrupted状态为false
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                // do nothing
            }
        }
    }
}
