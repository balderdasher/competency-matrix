package com.mrdios.competencymatrix.designpattern.patterns.creational.singleleton;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * <p>
 * JDK 版本：JDK1.5 起
 * <p>
 * 是否 Lazy 初始化：是
 * <p>
 * 是否多线程安全：是
 * <p>
 * 实现难度：较复杂
 * <p>
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * <p>
 * getInstance() 的性能对应用程序很关键。
 *
 * @author huxiong
 * @date 2017-01-22 11:55
 */
public class DoubleCheckedLockingSingleton {
    private volatile static DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        synchronized (DoubleCheckedLockingSingleton.class) {
            if (instance == null) {
                instance = new DoubleCheckedLockingSingleton();
            }
        }
        return instance;
    }
}
