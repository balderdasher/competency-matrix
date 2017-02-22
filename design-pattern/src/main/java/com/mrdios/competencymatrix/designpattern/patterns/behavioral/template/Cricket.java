package com.mrdios.competencymatrix.designpattern.patterns.behavioral.template;

/**
 * @author huxiong
 * @date 2017-02-22 15:19
 */
public class Cricket extends Game {
    @Override
    void init() {
        System.out.println("Cricket game init");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket game started");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket game finished");
    }
}
