package com.mrdios.competencymatrix.algorithm.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huxiong
 * @date 2017-04-07 15:40
 */
public class Practices {
    private static String[] a = "E A S Y Q U E S T I O N".split(" ");

    @Test
    public void sort() throws Exception {
        Selection.sort(a);
//        Assert.assertTrue(Selection.isSorted(a));
        Selection.show(a);
    }
}
