package com.mrdios.competencymatrix.designpattern.patterns.behavioral.chanofresponsibility;

/**
 * @author huxiong
 * @date 2017-02-15 15:30
 */
public class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
