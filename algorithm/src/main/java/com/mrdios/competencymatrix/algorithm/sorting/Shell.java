package com.mrdios.competencymatrix.algorithm.sorting;

import edu.princeton.cs.algs4.In;

import java.io.File;

/**
 * 希尔排序
 *
 * @author huxiong
 * @date 2017-04-07 9:36
 */
public class Shell {
    public static void sort(Comparable[] a) {
        // 将a[]按升序排列
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1; // 1,4,13,40,121,364,1093,...
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                // 将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]...之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String file = Shell.class.getClassLoader().getResource("sorting/shell.txt").getFile();
        String[] a = new In(new File(file)).readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
