package com.mrdios.competencymatrix.designpattern.patterns.creational.builder;

/**
 * 素食汉堡
 *
 * @author huxiong
 * @date 2017-01-22 15:19
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
