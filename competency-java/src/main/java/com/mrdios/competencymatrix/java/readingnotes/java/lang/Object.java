package com.mrdios.competencymatrix.java.readingnotes.java.lang;

import org.junit.Test;

/**
 * Created by balderdasher on 2016/8/11.
 */
public class Object {

    Boolean wait = true;

    @Test
    public void testClone() {
        java.lang.Object obj = new java.lang.Object();
//        obj.clone();//Object类没有实现Clonable接口 所以不能对Object调用此方法
    }

    /**
     * 没有实现Cloneable接口的类调用.clone()方法会抛出CloneNotSupportedException异常
     */
    @Test
    public void testUseClone() {
        NotImpClonable obj = new NotImpClonable();
        try {
            NotImpClonable obj2 = (NotImpClonable) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * clone对象的一些特性
     */
    @Test
    public void testClone3() {
        ImpCloneable obj = new ImpCloneable();
        obj.s = "hello";
        try {
            ImpCloneable cloneObj = (ImpCloneable) obj.clone();
            System.out.println(cloneObj.s);
            System.out.println(obj == cloneObj);
            System.out.println(obj.getClass() == cloneObj.getClass());
            System.out.println(obj.equals(cloneObj));//false：因为没有重写equals()方法，默认调用的是父类Object中的方法比较的内存地址
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 引用不存在时执行垃圾回收，对象所在的类可以重写finalize()方法执行一些操作
     */
    @Test
    public void testFinalize() {
        Object obj = new Object();
        System.out.println("引用设为null");
        obj = null;
        // 因为垃圾回收不知道什么时候能执行，所以手动触发一下(试试，并不能保证gc执行)
        System.out.println("触发垃圾回收");
        System.gc();
    }

    /**
     * 返回此 Object 的运行时类。返回的 Class 对象是由所表示类的 static synchronized 方法锁定的对象。
     * 实际结果类型是 Class<? extends |X|>，其中 |X| 表示清除表达式中的静态类型，该表达式调用 getClass。 例如，以下代码片段中不需要强制转换
     */
    @Test
    public void testGetClass() {
        Object obj = new SubObject();
        Class<? extends Object> c = obj.getClass();
        System.out.println(c.getSimpleName());
    }

    /**
     * 如果一个类没有重写equals()方法，那么此类对象的比较默认就是比较内存地址
     * 所以除非类重写了此方法并且改变了比较内存地址这一行为(如String)，否则所有对象都可以调用此方法实现和==相同的效果
     */
    @Test
    public void testEquals() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1.equals(obj2));//false
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1.equals(s2));//true,因为String重写了equals()方法比较的是字符串内容是否相同
    }

    /**
     * 此方法用于唤醒某个正在监视上等待此对象的线程(只唤醒单个)，如果有多个线程在等待此对象，则任意选择一个唤醒，
     * 线程通过在某个对象上调用wait()方法来在监视器上等待这个对象
     * <p>
     * 被唤醒的线程必须要等到当前线程解除对此对象的锁定，才能执行被唤醒的线程，而且是在此对象上与其它线程进行竞争执行权利，
     * 并不是被唤醒的这个线程就可以锁定这个对象
     * <p>
     * 此方法只能由该对象上监视器的所有者线程来调用，线程通过下面三个方法可以成为此对象监视器的所有者：
     * 1、执行此对象上的同步方法
     * 2、执行在此对象上进行同步的synchronized同步语句块
     * 3、如果此对象是Class类型的，执行该类的静态同步方法
     * <p>
     * 一次只能有一个线程拥有对象的监视器
     */
    @Test
    public void testNotify() {
        final Object obj = new Object();

        // 等待线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (obj) {
                        while (obj.wait) {
                            System.out.println(Thread.currentThread() + "在obj的监视器上等待");
                            obj.wait();
                        }
                        System.out.println(Thread.currentThread() + "被唤醒");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.setName("Thread 1");

        // 等待线程2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (obj) {
                        while (obj.wait) {
                            System.out.println(Thread.currentThread() + "在obj的监视器上等待");
                            obj.wait();
                        }
                        System.out.println(Thread.currentThread() + "被唤醒");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.setName("Thread 2");

        // 唤醒线程
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "3秒后在obj调用notify()方法唤醒一个在obj的监视器上等待的线程");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj) {
                    obj.wait = false;
                    obj.notify();
                }
            }
        });
        t3.setName("Thread 3");

        t3.start();
        t1.start();
        t2.start();
    }

    @Test
    public void testNotifyAll() {
        NotifyThread notify = new NotifyThread("notify");
        WaitThread wait01 = new WaitThread("wait01");
        WaitThread wait02 = new WaitThread("wait02");
        notify.start();
        wait01.start();
        wait02.start();
    }

    class NotImpClonable {
        String s;
    }

    class ImpCloneable implements Cloneable {
        String s;

        @Override
        protected java.lang.Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    class SubObject extends Object {

    }

    private String flag[] = {"true"};

    class NotifyThread extends Thread {
        public NotifyThread(String name) {
            super(name);
        }

        public void run() {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (flag) {
                flag[0] = "false";
                flag.notifyAll();
            }
        }
    }

    class WaitThread extends Thread {
        public WaitThread(String name) {
            super(name);
        }

        public void run() {
            synchronized (flag) {
                while (flag[0] != "false") {
                    System.out.println(getName() + " begin waiting!");
                    long waitTime = System.currentTimeMillis();
                    try {
                        flag.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    waitTime = System.currentTimeMillis() - waitTime;
                    System.out.println("wait time :" + waitTime);
                }
                System.out.println(getName() + " end waiting!");
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("引用不存在了，执行垃圾清理");
    }
}
