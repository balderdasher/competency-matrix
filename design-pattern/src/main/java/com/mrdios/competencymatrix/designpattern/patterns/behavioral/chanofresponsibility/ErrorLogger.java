package com.mrdios.competencymatrix.designpattern.patterns.behavioral.chanofresponsibility;

/**
 * @author huxiong
 * @date 2017-02-15 15:32
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
