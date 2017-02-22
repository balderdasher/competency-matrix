package com.mrdios.competencymatrix.designpattern.patterns.behavioral.state;

/**
 * @author huxiong
 * @date 2017-02-22 11:19
 */
public class StartState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Start state.";
    }
}
