package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter21;

/**
 * 更多的线程驱动更多的任务
 *
 * @author mrdios
 * @date 2016-07-27 15:18
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
