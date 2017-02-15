package com.mrdios.competencymatrix.designpattern.patterns.creational.builder;

/**
 * 可口可乐
 *
 * @author huxiong
 * @date 2017-01-22 15:25
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
