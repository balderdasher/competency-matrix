package com.mrdios.competencymatrix.designpattern.patterns.creational.singleleton;

/**
 * 懒汉式，线程不安全
 * <p>
 * 是否 Lazy 初始化：是
 * <p>
 * 是否多线程安全：否
 * <p>
 * 实现难度：易
 * <p>
 * 描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上* 它并不算单例模式。
 * <p>
 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 *
 * @author huxiong
 * @date 2017-01-22 11:44
 */
public class LazyThreadUnsafeSingleton {
    private static LazyThreadUnsafeSingleton instance;

    private LazyThreadUnsafeSingleton() {
    }

    public static LazyThreadUnsafeSingleton getInstance() {
        if (instance == null) {
            instance = new LazyThreadUnsafeSingleton();
        }
        return instance;
    }

}
