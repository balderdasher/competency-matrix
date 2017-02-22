package com.mrdios.competencymatrix.designpattern.patterns.behavioral.state;

/**
 * @author huxiong
 * @date 2017-02-22 11:17
 */
public class Context {
    private State state;

    public Context() {
        state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
