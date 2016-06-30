package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10.closure;

/**
 * 外围类实现一个接口
 * @author huxiong
 * @date 2016/06/28 21:42
 */
public class Callee1 implements Incrementable {
    private int i = 0;
    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}
