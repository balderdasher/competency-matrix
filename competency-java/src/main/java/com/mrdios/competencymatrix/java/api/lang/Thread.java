package com.mrdios.competencymatrix.java.api.lang;

import java.lang.Object;

/**
 * @author huxiong
 * @date 2016-08-14 13:41
 */
public class Thread {

    private static class Thread1 extends java.lang.Thread {

        Thread1(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 1; i < 10; i++) {
                System.out.println("线程" + getName() + "执行: " + i);
                if (i == 3) {
                    java.lang.Thread.yield();
                }
            }
        }
    }

    private static class Thread2 extends java.lang.Thread {

        Thread2(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 1; i < 10; i++) {
                System.out.println("线程" + getName() + "执行: " + i);
            }
        }
    }

    /**
     * yield()方法暂停执行当前线程对象，并执行其他线程
     * 以下两个线程将交替执行
     */
    private static void testYield() {
        Thread1 t1 = new Thread1("thread1");
        Thread1 t2 = new Thread1("thread2");
        t1.start();
        t2.start();
    }

    /**
     * 等待该线程终止
     */
    private static void testJoin() {
        Thread2 t1 = new Thread2("thread1");
        Thread2 t2 = new Thread2("thread2");
        try {
            t1.start();
            t1.join();//等待t1执行完成
            t2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 某个线程是否持有某个对象的锁
     */
    private static void testHoldsLock() throws Exception {
        final java.lang.Object object = new Object();
        new java.lang.Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println(java.lang.Thread.currentThread().getName() + " holds lock:" + java.lang.Thread.holdsLock(object));
                }
            }
        }, "t1").start();
        java.lang.Thread.sleep(1000);
        System.out.println(java.lang.Thread.currentThread().getName() + " holds lock:" + java.lang.Thread.holdsLock(object));
    }

    public static void main(String[] args) throws Exception {
//        testYield();
//        testJoin();
        testHoldsLock();
    }
}
