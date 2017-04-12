package com.mrdios.competencymatrix.algorithm.sorting;

import edu.princeton.cs.algs4.In;

/**
 * 排序模板类
 *
 * @author huxiong
 * @date 2017-04-06 9:04
 */
public class Example {
    /**
     * 排序算法
     *
     * @param a an array
     */
    public static void sort(Comparable[] a) {
        // sorting code
    }

    // 比较两个元素的大小
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // 交换两个元素的位置
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // 打印元素
    private static void show(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 判断数组是否已排序
     */
    public static boolean isSorted(Comparable[] a) {
        // 测试数组元素是否有序
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    // test case
    public static void main(String[] args) {
        String[] a = new In().readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
