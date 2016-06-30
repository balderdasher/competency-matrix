package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10.closure;

/**
 * @author huxiong
 * @date 2016/06/28 21:43
 */
public class MyIncrement {
    public void increment(){
        System.out.println("Other operation");
    }
    public static void f(MyIncrement mi){
        mi.increment();
    }
}
