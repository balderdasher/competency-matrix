package com.mrdios.competencymatrix.concurrency.chapter5_lock;

import org.junit.Test;

import java.util.Random;

/**
 * @author MrDios
 * @date 2017-06-26
 */
public class RandomTest {
    @Test
    public void test1() {
        Random random = new Random(10);
        Random random1 = new Random();
        System.out.println(random1.nextInt());
        for (int i = 0; i < 20; i++) {
            System.out.println(random.nextInt(10));
        }
    }
}
