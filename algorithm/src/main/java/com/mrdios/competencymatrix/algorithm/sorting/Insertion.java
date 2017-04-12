package com.mrdios.competencymatrix.algorithm.sorting;

import edu.princeton.cs.algs4.In;

import java.io.File;

/**
 * 插入排序
 *
 * @author huxiong
 * @date 2017-04-06 11:11
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        // 升序排列
        int N = a.length;   // 数组长度
        for (int i = 0; i < N; i++) {
            // 将a[i]插入到a[i-1]、a[i-1]、a[i-3]..之中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
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
        String file = Insertion.class.getClassLoader().getResource("sorting/tiny.txt").getFile();
        String[] a = new In(new File(file)).readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
