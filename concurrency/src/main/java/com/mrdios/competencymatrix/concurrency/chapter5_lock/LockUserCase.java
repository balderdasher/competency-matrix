package com.mrdios.competencymatrix.concurrency.chapter5_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock的使用示例
 *
 * @author MrDios
 * @date 2017-06-16
 */
public class LockUserCase {
    public static void useLock() {
        Lock lock = new ReentrantLock();
        lock.lock();            // 锁住,不能写在try块内
        try {
            // doSomething
        } finally {
            lock.unlock();      // 释放锁
        }
    }
}
