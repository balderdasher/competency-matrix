package com.mrdios.competencymatrix.algorithm.fundamentals.DataAbstract;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 计数器
 *
 * @author huxiong
 * @date 2017-03-30 11:39
 */
public class Counter implements Comparable<Counter> {
    private String name; // the counter name
    private int count = 0; // count num

    public Counter(String id) {
        this.name = id;
    }

    public void increment() {
        this.count += 1;
    }

    public int tally() {
        return this.count;
    }

    @Override
    public String toString() {
        return this.count + " " + this.name;
    }

    public int compareTo(Counter that) {
        if (this.count < that.count) {
            return -1;
        }
        if (this.count > that.count) {
            return +1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        // create n counters
        Counter[] hits = new Counter[n];
        for (int i = 0; i < n; i++) {
            hits[i] = new Counter("counter" + i);
        }

        // increment trials counters at random
        for (int t = 0; t < trials; t++) {
            hits[StdRandom.uniform(n)].increment();
        }

        // print results
        for (int i = 0; i < n; i++) {
            StdOut.println(hits[i]);
        }
    }
}
