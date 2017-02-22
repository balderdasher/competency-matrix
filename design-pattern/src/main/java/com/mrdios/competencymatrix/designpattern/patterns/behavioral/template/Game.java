package com.mrdios.competencymatrix.designpattern.patterns.behavioral.template;

/**
 * @author huxiong
 * @date 2017-02-22 15:14
 */
public abstract class Game {
    void init() {
        System.out.println("game init.");
    }

    abstract void startPlay();

    abstract void endPlay();

    /**
     * 模板方法，用于确定解决一个问题的顺序，不允许子类重写，子类可以重写模板方法中所调用的具体步骤方法
     */
    public final void play() {
        init();
        startPlay();
        endPlay();
    }
}
