package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10;

/**
 * Created by balderdasher on 2016/7/12.
 */
public class DoThis {
    public void f(){
        System.out.println("DotThis.f()");
    }

    public class Inner{
        public DoThis outer(){
            return DoThis.this;
        }
    }

    public Inner inner(){
        return new Inner();
    }

    public static void main(String[] args) {
        DoThis dt = new DoThis();
        DoThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
