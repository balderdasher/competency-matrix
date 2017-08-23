package com.mrdios.competencymatrix.spring.aop.example;

/**
 * @author mrdios
 * @date 2017-08-23
 */
public class ThreadTest {
    public static class Apple implements Runnable {
        private Integer num = 100;

        public void run() {
            for (int i = 0; i < num; i++) {
                synchronized (this) {
                    if (num > 0) {
                        System.out.println(Thread.currentThread().getName() + num);
                    }
                }
                num--;
            }
        }
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        new Thread(apple, "A").start();
        new Thread(apple, "B").start();
        new Thread(apple, "C").start();
        new Thread(apple, "D").start();
        new Thread(apple, "E").start();
        new Thread(apple, "F").start();
        new Thread(apple, "G").start();
        new Thread(apple, "H").start();
        new Thread(apple, "J").start();
        new Thread(apple, "K").start();
    }
}
