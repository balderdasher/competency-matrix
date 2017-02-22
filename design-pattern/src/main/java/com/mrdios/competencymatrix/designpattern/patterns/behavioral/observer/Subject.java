package com.mrdios.competencymatrix.designpattern.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题:被观察者
 *
 * @author huxiong
 * @date 2017-02-22 9:59
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
