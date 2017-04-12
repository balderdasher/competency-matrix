package com.mrdios.competencymatrix.algorithm.fundamentals.ProgrammingModel;

/**
 * 什么是算法、算法的定义
 *
 * @author huxiong
 * @date 2017-03-28 16:42
 */
public class Preface {

    /**
     * 求两个非负整数的最大公约数的计算机程序算法--欧几里得算法
     *
     * @param p 非负整数p
     * @param q 非负整数q
     * @return p和q的最大公约数
     */
    public static int gcd(int p, int q) {
        if (p < 0 || q < 0) {
            throw new IllegalArgumentException("the param number must greater than 0.");
        }
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }
}
