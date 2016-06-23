package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter8;

/**
 * @author huxiong
 * @date 2016/06/15 13:52
 */
public class Utils {
    /**
     * get CPU count according to Runtime
     *
     * @return the available processors of local machine
     */
    public static int getCpusCount() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static void main(String[] args) {
        int N_CPUS = getCpusCount();
        System.out.println("You have " + N_CPUS + " CPUS at local machine.");
        System.out.println(digui(10));
    }

    /**
     * 计算n的阶乘
     *
     * @param n
     * @return
     */
    public static int digui(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("参数错误");
        }
        if (n == 0) {
            return 1;
        } else {
            return n * digui(n - 1);
        }
    }
}
