package com.mrdios.competencymatrix.designpattern.patterns.creational.builder;

/**
 * 冷饮
 *
 * @author huxiong
 * @date 2017-01-22 15:18
 */
public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
