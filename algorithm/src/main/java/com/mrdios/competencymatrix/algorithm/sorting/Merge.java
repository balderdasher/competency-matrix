package com.mrdios.competencymatrix.algorithm.sorting;

import edu.princeton.cs.algs4.In;

import java.io.File;

/**
 * 归并排序
 *
 * @author huxiong
 * @date 2017-04-10 9:27
 */
public class Merge {
    /**
     * 归并排序的辅助数组
     */
    private static Comparable[] aux;

    /**
     * 自顶向下的归并排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sortUB(a, 0, a.length - 1);
    }

    private static void sortUB(Comparable[] a, int lo, int hi) {
        // 将数组a[lo..hi]排序
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sortUB(a, lo, mid);       // 将左半边排序
        sortUB(a, mid + 1, hi);// 将右半边排序
        merge(a, lo, mid, hi);  // 归并结果
    }

    /**
     * 自底向上的归并排序
     *
     * @param a
     */
    public static void sortBU(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 0; sz < N; sz = sz + sz) {// sz子数组大小
            for (int lo = 0; lo < N - sz; lo += sz + sz) {// lo:子数组索引
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    /**
     * 原地归并的抽象方法
     */
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        // 将a[1o..mid] 和 a[mid+1..hi] 归并
        int i = lo, j = mid + 1;
        // 将a[1o..hi]复制到aux[lo..hi]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // 归并回到a[lo..hi]
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean isSorted(Comparable[] a) {
        int mid = (a.length - 1) / 2;
        return less(a[mid], a[mid + 1]);
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String file = Merge.class.getClassLoader().getResource("sorting/tiny.txt").getFile();
        String[] a = new In(new File(file)).readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
