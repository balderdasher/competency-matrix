package com.mrdios.competencymatrix.designpattern.patterns.behavioral.state;

/**
 * @author huxiong
 * @date 2017-02-22 11:20
 */
public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Play is in stop state");
        context.setState(this);
    }

    public String toString() {
        return "Stop state";
    }
}
