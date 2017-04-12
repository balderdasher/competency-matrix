package com.mrdios.competencymatrix.algorithm.sorting;

import com.mrdios.competencymatrix.algorithm.fundamentals.AnalysisOfAlgorithm.Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 比较排序算法
 *
 * @author huxiong
 * @date 2017-04-06 15:52
 */
public class SortCompare {
    /**
     * 各种排序算法所花费的时间
     *
     * @param alg 排序算法
     * @param a   待排序数组
     * @return 排序花费时间
     */
    private static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion"))
            Insertion.sort(a);
        if (alg.equals("Selection"))
            Selection.sort(a);
        if (alg.equals("Shell")) {
            Shell.sort(a);
        }
        if (alg.equals("Merge")) {
            Merge.sort(a);
        }
        if (alg.equals("Quick")) {
            Quick.sort(a);
        }
        if (alg.equals("Heap")) {
            Heap.sort(a);
        }
        return timer.elapsedTime();
    }

    /**
     * 0.0到1.0之间的随机数组排序时间
     *
     * @param alg 算法
     * @param N   数组长度
     * @param T   重复次数
     * @return 使用算法将T个长度为N的数组排序所花费的时间
     */
    public static double timeRandomInput(String alg, int N, int T) {
        // 使用算法将T个长度为N的数组排序
        double total = 0d;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            // 进行一次测试（生成一个数组并排序）
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    // java SortCompare Insertion Selection 1000 300
    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T);// 算法1的总时间
        double t2 = timeRandomInput(alg2, N, T);// 算法2的总时间
        StdOut.printf("For %d random Doubles\n  %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}
