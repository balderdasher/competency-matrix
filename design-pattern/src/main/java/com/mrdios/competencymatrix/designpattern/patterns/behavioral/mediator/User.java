package com.mrdios.competencymatrix.designpattern.patterns.behavioral.mediator;

/**
 * @author huxiong
 * @date 2017-02-17 16:49
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}
