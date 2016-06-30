package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10.applicationframe;

/**
 * 抽象的Event用来描述要控制的事件
 * @author huxiong
 * @date 2016/06/28 22:30
 */
public abstract class Event {
    /** 事件执行时间 */
    private long eventTime;
    /** 事件执行的延迟时间 */
    protected final long delayTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start(){
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready(){
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();

}
