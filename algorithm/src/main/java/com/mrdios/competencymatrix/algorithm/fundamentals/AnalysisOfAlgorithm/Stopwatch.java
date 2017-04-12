package com.mrdios.competencymatrix.algorithm.fundamentals.AnalysisOfAlgorithm;

/**
 * 计时器--用于统计程序运行所花费的时间
 *
 * @author huxiong
 * @date 2017-04-05 9:54
 */
public class Stopwatch {
    private final long start;

    public Stopwatch() {
        this.start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        int[] a = new int[80000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        System.out.println(timer.elapsedTime());

    }
}
