package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10.closure;

/**
 * @author huxiong
 * @date 2016/06/28 21:49
 */
public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);//普通方式
        Caller caller2 = new Caller(c2.getCallbackRefrence());//闭包
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
