package com.mrdios.competencymatrix.designpattern.patterns.behavioral.mediator;

import java.util.Date;

/**
 * 作为一个中介者显示用户之间的对话
 *
 * @author huxiong
 * @date 2017-02-17 16:48
 */
public class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}
