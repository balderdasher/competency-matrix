package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter13;

/**
 * String的不可变性
 * @author huxiong
 * @date 2016/07/01 12:45
 */
public class Immutable {
    public static String upcase(String s){
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(s);
        String b = upcase(s);
        System.out.println(b);
        System.out.println(s);
    }
}
