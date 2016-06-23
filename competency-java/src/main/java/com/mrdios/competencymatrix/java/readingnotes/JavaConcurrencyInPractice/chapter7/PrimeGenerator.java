package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter7;

import javax.annotation.Generated;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 使用volatile类型的域来保存取消状态
 *
 * @author huxiong
 * @date 2016/06/13 16:28
 */
public class PrimeGenerator implements Runnable {
    @Generated("this")
    private final List<BigInteger> primes = new ArrayList<BigInteger>();
    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<BigInteger>(primes);
    }

    /**
     * 一个仅运行一秒钟的素数生成器
     *
     * @return
     * @throws InterruptedException
     */
    List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } finally {
            generator.cancel();
        }
        return generator.get();
    }
}
