package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter12;

/**
 * 处理自定义异常
 * @author huxiong
 * @date 2016/06/30 16:54
 */
public class InheritingException {
    public void f() throws SimpleException{
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingException sed = new InheritingException();
        try {
            sed.f();
        } catch (SimpleException e) {
            System.out.println("Caught it!");
        }
    }
}
