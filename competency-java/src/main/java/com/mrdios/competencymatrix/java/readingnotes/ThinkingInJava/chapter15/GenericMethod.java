package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter15;

/**
 * 泛型方法
 * @author huxiong
 * @date 2016/07/07 15:00
 */
public class GenericMethod {
    public <T> void f(T x){
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        gm.f("baby");
        gm.f(1);
        gm.f(3.0f);
        gm.f(5.0d);
        gm.f(gm);
    }
}
