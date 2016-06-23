package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter5;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 基于FutureTask的Memoizing封装器
 * 近乎完美但是仍然存在两个线程计算出相同值的漏洞
 *
 * @author huxiong
 * @date 2016/06/13 13:41
 */
public class Memoizer3<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(final A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws InterruptedException {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<V>(eval);
            f = ft;
            cache.put(arg, ft);
            ft.run();//这里将调用c.compute
        }
        try {
            return f.get();
        } catch (ExecutionException e) {
            System.out.println("oops");
        }
        return null;
    }
}
