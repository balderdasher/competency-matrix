package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用ConcurrentHashMap代替HashMap改进HashMap糟糕的并发行为
 * 由于ConcurrentHashMap是线程安全的，因此在访问底层Map时就不需要进行同步，因而避免了在对compute方法进行同步时带来的串行性
 * <p/>
 * 问题：如果某个线程启动了一个开销很大的计算但是其他线程并不知道这个计算正在进行，那么就有可能会重复这个计算
 *
 * @author huxiong
 * @date 2016/06/13 13:31
 */
public class Memoizer2<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    /**
     * @param arg
     * @return
     * @throws InterruptedException
     */
    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
