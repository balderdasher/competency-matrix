package com.mrdios.competencymatrix.designpattern.patterns.behavioral.observer;

/**
 * @author huxiong
 * @date 2017-02-22 10:06
 */
public class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}
