package com.mrdios.competencymatrix.java.api.lang;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Class 类的实例表示正在运行的 Java 应用程序中的类和接口。枚举是一种类，注释是一种接口。每个数组属于被映射为 Class 对象的一个类，所有具有相同元素类型和维数的数组都共享该 Class 对象。基本的 Java 类型（boolean、byte、char、short、int、long、float 和 double）和关键字 void 也表示为 Class 对象。
 * <p>
 * Class 没有公共构造方法。Class 对象是在加载类时由 Java 虚拟机以及通过调用类加载器中的 defineClass 方法自动构造的。
 *
 * @author huxiong
 * @date 2016-08-13 16:50
 */
public class Class {

    private String name;

    public Class(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Test
    public void testCast() {
        com.mrdios.competencymatrix.java.api.lang.Object object = new com.mrdios.competencymatrix.java.api.lang.Object();
        java.lang.Class c = Class.class;
    }

    public static void testGetDeclaredConstructors() {
        try {
            Constructor<Class> c = Class.class.getDeclaredConstructor(String.class);
            Class stu = c.newInstance("小明");
            System.out.println(stu.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void testGetMethod() {
        java.lang.Class<Class> c = Class.class;
        try {
            Method m = c.getDeclaredMethod("setName", String.class);
            System.out.println(m.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static int max() {
        int[] i = new int[10];
        for (int j = 0; j < 10; j++) {
            i[j] = j;
        }
        int result = i[0];
        for (int j = 1; j < i.length; j++) {
            result = Math.max(result, i[j]);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        String[] s = new String[3];
        String[] s2 = new String[3];
        Integer[] i = new Integer[3];
        System.out.println(s.getClass());
        System.out.println(s.getClass() == s2.getClass());
        System.out.println(i.getClass());
        System.out.println(Class.class);
        System.out.println(byte.class.getName());
        System.out.println(double.class.getName());
        testGetDeclaredConstructors();
        Runtime runtime = Runtime.getRuntime();
        runtime.halt(1);
        System.out.println(max());
        System.out.println(Math.random());
    }
}
