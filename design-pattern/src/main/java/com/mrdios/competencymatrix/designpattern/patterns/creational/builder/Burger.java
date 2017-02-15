package com.mrdios.competencymatrix.designpattern.patterns.creational.builder;

/**
 * 汉堡
 *
 * @author huxiong
 * @date 2017-01-22 15:15
 */
public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();

}
