package com.mrdios.competencymatrix.designpattern.patterns.behavioral.interpreter;

/**
 * 主要解释器类
 *
 * @author huxiong
 * @date 2017-02-16 14:40
 */
public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}
