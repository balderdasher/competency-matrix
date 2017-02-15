package com.mrdios.competencymatrix.designpattern.patterns.behavioral.chanofresponsibility;

/**
 * @author huxiong
 * @date 2017-02-15 15:33
 */
public class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
