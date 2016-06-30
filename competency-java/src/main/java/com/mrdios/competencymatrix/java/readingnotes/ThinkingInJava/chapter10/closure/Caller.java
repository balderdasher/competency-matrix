package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10.closure;

/**
 * @author huxiong
 * @date 2016/06/28 21:47
 */
public class Caller {
    private Incrementable callbackRefrence;

    Caller(Incrementable cbh) {
        callbackRefrence = cbh;
    }

    void go() {callbackRefrence.increment();
    }
}
