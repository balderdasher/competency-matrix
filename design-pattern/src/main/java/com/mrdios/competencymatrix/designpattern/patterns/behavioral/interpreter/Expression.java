package com.mrdios.competencymatrix.designpattern.patterns.behavioral.interpreter;

/**
 * 表达式接口
 *
 * @author huxiong
 * @date 2017-02-16 14:39
 */
public interface Expression {
    boolean interpret(String context);
}
