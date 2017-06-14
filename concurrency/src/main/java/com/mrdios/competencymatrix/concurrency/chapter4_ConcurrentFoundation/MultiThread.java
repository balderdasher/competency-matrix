package com.mrdios.competencymatrix.concurrency.chapter4_ConcurrentFoundation;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 用JMX查看普通的Java程序所包含的线程
 *
 * @author MrDios
 * @date 2017-06-12
 */
public class MultiThread {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        // 获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的监视器(monitor)和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程ID和线程名称
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
    }
}