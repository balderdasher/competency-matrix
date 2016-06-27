package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter9.strategy;

/**
 * 大写转换处理类
 * @author huxiong
 * @date 2016/06/27 15:48
 */
public class Upcase extends Processor {
    @Override
    String process(Object input) {
        return ((String)input).toUpperCase();
    }
}
