package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter21;

/**
 * 线程的基本使用
 *
 * @author mrdios
 * @date 2016-07-27 14:54
 */
public class BasicThread {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
