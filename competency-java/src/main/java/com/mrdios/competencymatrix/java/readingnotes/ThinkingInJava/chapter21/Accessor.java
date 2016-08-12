package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter21;

import java.sql.SQLOutput;

/**
 * @author mrdios
 * @date 2016-08-02 15:04
 */
public class Accessor implements Runnable {
    private final int id;

    public Accessor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            ThreadLocalVarHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "#" + id + ": " + ThreadLocalVarHolder.get();
    }
}
