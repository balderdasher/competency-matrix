package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter9.strategy;

/**
 * 策略设计模式
 * @author huxiong
 * @date 2016/06/27 15:56
 */
public class Apply {

    public static String s = "you can you up no can no bibi";

    /**
     * 策略设计模式：根据传入不同的处理器采取不同的处理方式
     * @param p 处理器（策略）
     * @param s 待处理字符串
     */
    public static void process(Processor p, Object s){
        System.out.print("Using Processor " + p.name() + "：");
        System.out.println(p.process(s));
    }

    public static void main(String[] args) {
        process(new Upcase(),s);
        process(new Downcase(),s);
    }

}
