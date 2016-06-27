package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter9.adapter;

/**
 * @author huxiong
 * @date 2016/06/27 16:59
 */
public class Apply {
    public static void process(Processor p,Object s){
        System.out.print("Using Processor " + p.name() + "：");
        System.out.println(p.process(s));
    }
}
