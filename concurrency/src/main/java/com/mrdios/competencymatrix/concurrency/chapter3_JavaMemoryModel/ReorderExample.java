package com.mrdios.competencymatrix.concurrency.chapter3_JavaMemoryModel;

/**
 * 重排序对多线程的影响
 *
 * @author MrDios
 * @date 2017-06-08
 */
public class ReorderExample {
    int a = 0;              // 共享变量a
    boolean flag = false;   // 标识a是否已被写入

    public void writer() {
        a = 1;              // 1
        flag = true;        // 2
    }

    public void reader() {
        if (flag) {         // 3
            int i = a * a;  // 4
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        final ReorderExample example = new ReorderExample();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                example.writer();
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                example.reader();
            }
        });

        A.start();
        B.start();
    }
}
