package com.mrdios.competencymatrix.java.api.java.lang;

import java.lang.Thread;
import java.util.Random;

/**
 * @author CodePorter
 * @date 2017-12-21
 */
public class ThreadLoaclTest {
    public static ThreadLocal<String> userName = new ThreadLocal<>();
    public static ThreadLocal<Integer> userLevel = new ThreadLocal<>();

    static class Processor implements Runnable {
        private String id;

        public Processor(String id) {
            this.id = id;
        }

        @Override
        public void run() {
            userName.set("user_" + id);
            userLevel.set(new Random().nextInt(6));
            System.out.println(java.lang.Thread.currentThread().getName() + " local vars:{" + "username:" + userName.get() + ",userlevel:" + userLevel.get() + "}");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String id = i + 1 + "";
            new Thread(new Processor(id), "thread_" + id).start();
        }
    }
}
