package com.mrdios.competencymatrix.java.readingnotes.algorithm;

/**
 * 快速排序
 *
 * @author huxiong
 * @date 2017-03-10 15:06
 */
public class QuickSort {
    public static void quickSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int lo = l, hi = r, base = array[l];// 基准数
        while (lo < hi) {
            // 从右往左数，若有小于基准数的则把此数提前
            while (array[hi] >= base && lo < hi) {
                hi--;
            }
            array[lo] = array[hi];
            // 从左往右数，若有大于基准数的则把此数置后
            while (array[lo] <= base && lo < hi) {
                lo++;
            }
            array[hi] = array[lo];
        }
        // lo与hi重合时此位置填入基准数完成一次排序，此时数组被分为两部分，基准数左边的比它小，右边的比它大
        array[hi] = base;
        // 对基准数左右两侧进行以上排序
        quickSort(array, l, hi - 1);
        quickSort(array, hi + 1, r);
    }

    public static void simpleQuickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 6, 4, 2, 1, 7, 9, 8, 10};
        quickSort(nums, 0, 5);
//        simpleQuickSort(nums);
        System.out.print("排序结果：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }
}
