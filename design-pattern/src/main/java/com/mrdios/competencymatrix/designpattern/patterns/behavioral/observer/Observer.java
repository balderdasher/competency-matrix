package com.mrdios.competencymatrix.designpattern.patterns.behavioral.observer;

/**
 * 观察者
 *
 * @author huxiong
 * @date 2017-02-22 10:00
 */
public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}
