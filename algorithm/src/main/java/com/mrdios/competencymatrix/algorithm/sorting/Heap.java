package com.mrdios.competencymatrix.algorithm.sorting;

import edu.princeton.cs.algs4.In;

import java.io.File;

/**
 * 堆排序--两个阶段
 * 1、构造堆
 * 2、下沉排序
 *
 * @author huxiong
 * @date 2017-04-11 15:59
 */
public class Heap {

    public static void sort(Comparable[] a) {
        int n = a.length;
        // 构造堆
        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
        }
        // 下沉排序
        while (n > 1) {
            exch(a, 1, n--);
            sink(a, 1, n);
        }
    }

    /**
     * 由上至下的堆有序变化（下沉）的实现
     * k节点的子节点位于2k和2k+1
     *
     * @param pq an array
     * @param k  扫描开始的位置
     * @param n  结束位置
     */
    private static void sink(Comparable[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j, j + 1)) {
                j++;
            }
            if (!less(pq, k, j)) {
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i - 1].compareTo(pq[j - 1]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = swap;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String file = Heap.class.getClassLoader().getResource("sorting/tiny.txt").getFile();
        String[] a = new In(new File(file)).readAllStrings();
        sort(a);
        show(a);
    }
}
