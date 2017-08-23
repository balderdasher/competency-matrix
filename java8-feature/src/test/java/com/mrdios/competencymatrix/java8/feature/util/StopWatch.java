package com.mrdios.competencymatrix.java8.feature.util;

/**
 * @author MrDios
 * @date 2017-08-23
 */
public class StopWatch {
    private final long start;

    public StopWatch() {
        this.start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public static void main(String[] args) {
        StopWatch timer = new StopWatch();
        int[] a = new int[80000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        System.out.println(timer.elapsedTime());

    }
}
