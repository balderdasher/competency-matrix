package com.mrdios.competencymatrix.java.readingnotes.java.lang;

/**
 * Created by balderdasher on 2016/8/12.
 */
public class Notify2 {

    public static void main(String[] args) {
        final Object obj = new Object();

        // 等待线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (obj) {
                        while (obj.wait) {
                            System.out.println(Thread.currentThread() + "在obj的监视器上等待");
                            obj.wait();
                        }
                        System.out.println(Thread.currentThread() + "被唤醒");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.setName("Thread 1");

        // 等待线程2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (obj) {
                        while (obj.wait) {
                            System.out.println(Thread.currentThread() + "在obj的监视器上等待");
                            obj.wait();
                        }
                        System.out.println(Thread.currentThread() + "被唤醒");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.setName("Thread 2");

        // 唤醒线程
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "3秒后在obj调用notify()方法唤醒一个在obj的监视器上等待的线程");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj) {
                    obj.wait = false;
                    obj.notify();
                }
            }
        });
        t3.setName("Thread 3");

        t3.start();
        t1.start();
        t2.start();
    }
}
