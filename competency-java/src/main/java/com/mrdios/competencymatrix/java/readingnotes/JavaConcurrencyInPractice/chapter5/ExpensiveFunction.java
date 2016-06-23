package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter5;

import java.math.BigInteger;

/**
 * @author huxiong
 * @date 2016/06/13 13:20
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {

    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        // 在经过长时间的计算后
        return new BigInteger(arg);
    }
}
