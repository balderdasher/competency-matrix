package com.mrdios.competencymatrix.designpattern.patterns.behavioral.observer;

/**
 * @author huxiong
 * @date 2017-02-22 10:10
 */
public class App {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
