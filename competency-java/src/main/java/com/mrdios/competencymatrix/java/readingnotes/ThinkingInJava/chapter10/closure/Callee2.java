package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10.closure;

/**
 * 内部类实现接口
 * @author huxiong
 * @date 2016/06/28 21:45
 */
public class Callee2 extends MyIncrement {
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    private class Closure implements Incrementable{

        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }
    Incrementable getCallbackRefrence(){
        return new Closure();
    }
}
