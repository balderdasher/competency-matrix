package com.mrdios.competencymatrix.designpattern.patterns.behavioral.template;

/**
 * @author huxiong
 * @date 2017-02-22 15:24
 */
public class App {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        game = new Football();
        game.play();
    }
}
