package com.mrdios.competencymatrix.designpattern.patterns.creational.builder;

/**
 * 鸡肉汉堡
 *
 * @author huxiong
 * @date 2017-01-22 15:23
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
