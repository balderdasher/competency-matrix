package com.mrdios.competencymatrix.concurrency.chapter7_13atomic_classes;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 原子更新字段类的使用
 *
 * @author MrDios
 * @date 2017-06-22
 */
public class AtomicIntegerFieldUpdaterTest {
    // 创建原子更新器，并设置要更新的对象类和对象的属性
    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "oid");

    public static void main(String[] args) {
        User tom = new User("tom", 10);
        // 按照之前的设置原子更新对象的字段
        System.out.println(a.getAndIncrement(tom));
        System.out.println(a.get(tom));
    }

    public static class User {
        private String name;
        public volatile int oid;

        public User(String name, int oid) {
            this.name = name;
            this.oid = oid;
        }

        public String getName() {
            return name;
        }

        public int getOid() {
            return oid;
        }
    }
}
