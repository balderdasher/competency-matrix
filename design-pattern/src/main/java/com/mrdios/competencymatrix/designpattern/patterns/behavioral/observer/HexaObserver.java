package com.mrdios.competencymatrix.designpattern.patterns.behavioral.observer;

/**
 * @author huxiong
 * @date 2017-02-22 10:09
 */
public class HexaObserver extends Observer {
    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
