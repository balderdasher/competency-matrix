package com.mrdios.competencymatrix.concurrency.chapter4_ConcurrentFoundation;

import com.mrdios.competencymatrix.concurrency.util.SleepUtils;

import java.util.Date;

/**
 * Thread.join()的使用
 *
 * @author MrDios
 * @date 2017-06-14
 */
public class Join {
    public static void main(String[] args) {
        final Thread jerry = new Thread(new Runnable() {
            @Override
            public void run() {
                SleepUtils.second(5);
                System.out.println("Jerry睡醒了");
            }
        });
        Thread tom = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date());
                try {
//                    jerry.join();               // 1
                    jerry.join(8000);       // 2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date());
            }
        });

        jerry.start();
        tom.start();
    }
}
