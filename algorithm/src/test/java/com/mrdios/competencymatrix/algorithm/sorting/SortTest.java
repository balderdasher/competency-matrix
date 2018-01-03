package com.mrdios.competencymatrix.algorithm.sorting;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author CodePorter
 * @date 2017-09-11
 */
public class SortTest {

    public void sortTest(Comparable[] a) {
        int size = a.length;
        Comparable tmp1 = a[0];
        Comparable tmp2 = 0;
        for (int index = 0; index <= size / 2; index += 2) {
            a[index] = a[size - 1 - index];
            tmp2 = a[index + 1];
            a[index + 1] = tmp1;
            tmp1 = tmp2;
        }
    }

    @Test
    public void test() {
        Integer[] a = new Integer[100];
        for (int i = 0; i < 100; i++) {
            a[i] = i + 1;
        }
        sortTest(a);
        System.out.println(Arrays.toString(a));
    }

}
