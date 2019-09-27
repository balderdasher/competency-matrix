package com.mrdios.competencymatrix.java.api.lang.ref;

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
        Reference<? extends Entity> inq = null;
        inq = rq.poll();
        if (inq != null) {
            System.out.println("In queue: " + inq + " : " + inq.get());
        }
    }

    public static void testReferences(ReferenceType type) {
        Set<Object> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            Reference<Entity> reference = null;
            String entityId = type.toString() + ": " + i;
            Entity strong = null;
            switch (type) {
                case SOFT:
                    reference = new SoftReference<>(new Entity(entityId), rq);
                    break;
                case WEAK:
                    reference = new WeakReference<>(new Entity(entityId), rq);
                    break;
                case PHANTOM:
                    reference = new PhantomReference<>(new Entity(entityId), rq);
                    break;
                case STRONG:
                    strong = new Entity(entityId);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown reference type..");
            }
            System.out.println("Just created: " + (type == ReferenceType.STRONG ? strong : reference.get() + reference.toString()));
            set.add((type == ReferenceType.STRONG ? strong : reference));
        }
        System.gc();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkQueue();
    }

    public static void testRefs() {
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

    public static void main(String[] args) {
        testReferences(ReferenceType.PHANTOM);
    }


    private static class Entity {
        private static final int SIZE = 1024;
        private byte[] d = new byte[SIZE * SIZE];
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

    static enum ReferenceType {
        STRONG, SOFT, WEAK, PHANTOM
    }
}
