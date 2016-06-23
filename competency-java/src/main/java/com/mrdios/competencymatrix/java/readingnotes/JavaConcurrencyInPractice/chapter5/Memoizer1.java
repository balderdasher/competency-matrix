package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter5;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用hashMap保存之前的计算结果
 *
 * @author huxiong
 * @date 2016/06/13 13:21
 */
public class Memoizer1<A, V> implements Computable<A, V> {
    @Generated("this")
    private final Map<A, V> cache = new HashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    /**
     * 首先检查需要的结果是否已经在缓存中，存在则返回之前的计算值，否则将把计算结果缓存在HashMap中然后再返回
     * HashMap不是线程安全的，因此要确保两个线程不会同时访问HashMap，所以对整个方法进行了同步
     * 这种方法能够保证线程安全性，但是会带来一个明显的伸缩问题：每次只有一个线程能够执行compute，其它线程只能等待，这种情况下的计算时间可能比没有缓存的时间还要长，性能得不到提升--具有糟糕的并发性
     *
     * @param arg
     * @return
     * @throws InterruptedException
     */
    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
