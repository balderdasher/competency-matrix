package com.mrdios.competencymatrix.java8.feature.lambda;

/**
 * Lambda表达式
 *
 * @author mrdios
 * @date 2017-08-19
 */
public class Lambda {

    public static void createThread() {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("do something.");
            }
        }).start();
    }

    public static void createThreadWithLambda() {
        new Thread(() -> System.out.println("do something.")).start();
    }

    public static void main(String[] args) {
        createThreadWithLambda();
    }
}
