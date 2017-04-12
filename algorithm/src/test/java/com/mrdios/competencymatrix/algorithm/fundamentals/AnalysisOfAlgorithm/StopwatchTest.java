package com.mrdios.competencymatrix.algorithm.fundamentals.AnalysisOfAlgorithm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author huxiong
 * @date 2017-04-06 16:33
 */
public class StopwatchTest {

    @Test
    public void testStopWatch() {
        Stopwatch timer = new Stopwatch();
        int[] a = new int[1000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        double time = timer.elapsedTime();
        System.out.println(time);
    }

}