package com.mrdios.competencymatrix.designpattern.patterns.creational.builder;

/**
 * 百事可乐
 *
 * @author huxiong
 * @date 2017-01-22 15:25
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
