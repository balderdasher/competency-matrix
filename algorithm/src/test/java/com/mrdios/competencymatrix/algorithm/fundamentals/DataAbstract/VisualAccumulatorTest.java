package com.mrdios.competencymatrix.algorithm.fundamentals.DataAbstract;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author huxiong
 * @date 2017-03-29 19:22
 */
public class VisualAccumulatorTest {


    public static void main(String[] args) {
        int T = Integer.parseInt("1000");
        VisualAccumulator a = new VisualAccumulator(T, 1.0);
        for (int i = 0; i < T; i++) {
            a.addDataValue(StdRandom.random());
        }
        StdOut.println(a);
    }

}