package com.mrdios.competencymatrix.designpattern.patterns.behavioral.mediator;

/**
 * @author huxiong
 * @date 2017-02-17 16:52
 */
public class App {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi!Jobn!");
        john.sendMessage("Hello!Robert!");
    }
}
