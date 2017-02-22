package com.mrdios.competencymatrix.designpattern.patterns.behavioral.strategy;

/**
 * @author huxiong
 * @date 2017-02-22 15:04
 */
public class App {
    public static final String str = "Helo World";

    /**
     * 策略设计模式：根据传入不同的处理器采取不同的处理方式
     *
     * @param processor
     * @param str
     */
    public static void process(Processor processor, String str) {
        System.out.println("Using processer: " + processor.getClass().getSimpleName());
        System.out.println(processor.process(str));
    }

    public static void main(String[] args) {
        process(new UpperCase(), str);
        process(new DownCase(), str);
    }
}
