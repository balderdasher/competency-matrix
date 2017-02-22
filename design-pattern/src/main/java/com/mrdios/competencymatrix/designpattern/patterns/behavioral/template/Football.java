package com.mrdios.competencymatrix.designpattern.patterns.behavioral.template;

/**
 * @author huxiong
 * @date 2017-02-22 15:21
 */
public class Football extends Game {
    @Override
    void init() {
        super.init();
        System.out.println("Football game init");
    }

    @Override
    void startPlay() {
        System.out.println("Football game started");
    }

    @Override
    void endPlay() {
        System.out.println("Football game finished");
    }
}
