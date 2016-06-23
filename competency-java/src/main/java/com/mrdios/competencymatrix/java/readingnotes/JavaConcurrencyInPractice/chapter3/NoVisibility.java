package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter3;

/**
 * 在没有同步的情况下共享变量(不要这么做)
 *
 * @author huxiong
 * @date 2016/05/11 17:04
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
