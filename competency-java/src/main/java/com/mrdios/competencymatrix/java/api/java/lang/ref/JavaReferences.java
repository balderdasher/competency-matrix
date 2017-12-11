package com.mrdios.competencymatrix.java.api.java.lang.ref;

import java.lang.ref.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Java中的几种引用（强->软->弱->虚）
 *
 * @author CodePorter
 * @date 2017-12-11
 */
public class JavaReferences {
    private static ReferenceQueue<Entity> rq = new ReferenceQueue<>();

    public static void checkQueue() {
        // 从队列中取出一个引用
        Reference<? extends Entity> inq = rq.poll();
        if (inq != null) {
            System.out.println("In queue: " + inq + " : " + inq.get());
        }
    }

    public static void main(String[] args) {
        final int size = 10;
        // 创建10个Entity对象以及10个软引用
        Set<SoftReference<Entity>> sa = new HashSet<>();
        for (int i = 0; i < size; i++) {
            SoftReference<Entity> ref = new SoftReference<>(new Entity("Soft " + i), rq);
            System.out.println("Just created: " + ref.get());
            sa.add(ref);
        }
        System.gc();
        checkQueue();

        // 创建10个Entity对象以及10个弱引用
        Set<WeakReference<Entity>> wa = new HashSet<>();
        for (int i = 0; i < size; i++) {
            WeakReference<Entity> ref = new WeakReference<Entity>(new Entity("Weak " + i), rq);
            System.out.println("Just created: " + ref.get());
            wa.add(ref);
        }
        System.gc();
        checkQueue();

        // 创建10个Entity对象以及10个虚引用
        Set<PhantomReference<Entity>> pa = new HashSet<>();
        for (int i = 0; i < size; i++) {
            PhantomReference<Entity> ref = new PhantomReference<>(new Entity("Phantom " + i), rq);
            System.out.println("Just created: " + ref.get());
            pa.add(ref);
        }
        System.gc();
        checkQueue();
    }


    private static class Entity {
        private static final int SIZE = 1000;
        private double[] d = new double[SIZE];
        private String id;

        public Entity(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return id;
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("Finalizing " + id);
        }
    }
}
