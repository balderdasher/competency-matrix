package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10;

/**
 * @author huxiong
 * @date 2016/06/28 10:30
 */
public interface Selector {
    boolean end();
    Object current();
    void next();
}
