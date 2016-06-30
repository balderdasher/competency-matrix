package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10;

/**
 * @author huxiong
 * @date 2016/06/28 11:08
 */
public class DotThis {
    public void f(){
        System.out.println("DotThis.f()");
    }

    public class Inner{
        public DotThis outer(){
            return DotThis.this;
        }
    }

    public Inner inner(){
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
