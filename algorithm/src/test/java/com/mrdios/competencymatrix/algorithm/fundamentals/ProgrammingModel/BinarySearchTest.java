package com.mrdios.competencymatrix.algorithm.fundamentals.ProgrammingModel;

import com.mrdios.competencymatrix.algorithm.fundamentals.ProgrammingModel.BinarySearch;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author huxiong
 * @date 2017-03-28 18:06
 */
public class BinarySearchTest {
    @Test
    public void indexOf() throws Exception {
        // int[1,2,3...9]
        int[] array = new int[9];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        Arrays.sort(array);
        Assert.assertTrue(BinarySearch.indexOf(array, 8) == 7);
        Assert.assertTrue(BinarySearch.indexOf(array, 10) == -1);
    }

}