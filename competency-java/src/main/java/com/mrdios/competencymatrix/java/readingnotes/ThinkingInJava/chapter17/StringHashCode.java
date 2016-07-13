package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter17;

/**
 * Created by balderdasher on 2016/7/13.
 */
public class StringHashCode {
    public static void main(String[] args) {
        String[] hellos = "Hello Hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
    }
}
