package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter9.adapter;

/**
 * @author huxiong
 * @date 2016/06/27 16:50
 */
public interface Processor {
    String name();
    Object process(Object input);
}
