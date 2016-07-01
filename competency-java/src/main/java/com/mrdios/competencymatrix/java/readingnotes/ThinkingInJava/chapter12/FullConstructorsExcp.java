package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter12;

/**
 * 带参数构造器自定义异常处理
 * @author huxiong
 * @date 2016/06/30 17:03
 */
public class FullConstructorsExcp {
    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);//发送给某个输出流
        }
    }
}
