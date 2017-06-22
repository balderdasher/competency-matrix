package com.mrdios.competencymatrix.concurrency.chapter6_containerAndFrame;

import java.util.HashMap;
import java.util.UUID;

/**
 * 多线程环境下，HashMap进行put操作会引起死循环
 *
 * @author MrDios
 * @date 2017-06-21
 */
public class NotThreadSafeHashMap {
    public static void test() throws InterruptedException {
        final HashMap<String, String> map = new HashMap<>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }

                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();
    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
