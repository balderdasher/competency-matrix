package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter12;

/**
 * 带字符串参数构造器的自定义异常
 * @author huxiong
 * @date 2016/06/30 17:00
 */
public class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
