package com.mrdios.competencymatrix.designpattern.patterns.creational.singleleton;

/**
 * 懒汉式，线程安全
 * <p>
 * 是否 Lazy 初始化：是
 * <p>
 * 是否多线程安全：是
 * <p>
 * 实现难度：易
 * <p>
 * 描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
 * <p>
 * 优点：第一次调用才初始化，避免内存浪费。
 * <p>
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 *
 * @author huxiong
 * @date 2017-01-22 11:47
 */
public class LazyThreadSafeSingleLeton {
    private static LazyThreadSafeSingleLeton instance;

    private LazyThreadSafeSingleLeton() {
    }

    public static synchronized LazyThreadSafeSingleLeton getInstance() {
        if (instance == null) {
            instance = new LazyThreadSafeSingleLeton();
        }
        return instance;
    }
}
