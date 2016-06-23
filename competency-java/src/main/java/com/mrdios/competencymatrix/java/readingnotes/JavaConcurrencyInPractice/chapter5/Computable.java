package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter5;

/**
 * 构建高效并且可伸缩的结果缓存
 *
 * @author huxiong
 * @date 2016/06/13 13:18
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
