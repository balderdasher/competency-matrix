package com.mrdios.competencymatrix.designpattern.patterns.behavioral.observer;

/**
 * 具体观察者类
 *
 * @author huxiong
 * @date 2017-02-22 10:04
 */
public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
