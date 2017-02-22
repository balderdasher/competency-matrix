package com.mrdios.competencymatrix.designpattern.patterns.behavioral.state;

/**
 * @author huxiong
 * @date 2017-02-22 11:22
 */
public class App {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState().toString());

    }
}
