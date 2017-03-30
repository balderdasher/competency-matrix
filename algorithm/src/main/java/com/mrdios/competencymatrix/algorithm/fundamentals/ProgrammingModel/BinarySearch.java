package com.mrdios.competencymatrix.algorithm.fundamentals.ProgrammingModel;

import java.util.Arrays;

/**
 * @author huxiong
 * @date 2017-03-28 17:41
 */
public class BinarySearch {

    /**
     * 二分查找（折半查找）
     *
     * @param a   整数数组，必须是经过排序的
     * @param key search key
     * @return 找到返回key在a中的下标否则-1
     */
    public static int indexOf(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归实现
     *
     * @param a
     * @param key
     * @return
     */
    public static int rank(int[] a, int key) {
        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        // 如果a中存在key，它的索引不会小于lo且不会大于hi
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[9];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        Arrays.sort(array);
        System.out.println(indexOf(array, 8));
    }
}
