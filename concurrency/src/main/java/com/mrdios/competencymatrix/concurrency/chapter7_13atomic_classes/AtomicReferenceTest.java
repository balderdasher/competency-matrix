package com.mrdios.competencymatrix.concurrency.chapter7_13atomic_classes;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子方式更新引用类型
 *
 * @author MrDios
 * @date 2017-06-22
 */
public class AtomicReferenceTest {
    public static AtomicReference<User> atomicUserRef = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("tom", 15);
        atomicUserRef.set(user);
        System.out.println(atomicUserRef.get());
        User updateUser = new User("jerry", 17);
        atomicUserRef.compareAndSet(user, updateUser);
        System.out.println(atomicUserRef.get());
        System.out.println(user);
    }

    static class User {
        private String name;
        private int oid;

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

//        @Override
//        public String toString() {
//            return "User{" +
//                    "name='" + name + '\'' +
//                    ", oid=" + oid +
//                    '}';
//        }
    }
}
