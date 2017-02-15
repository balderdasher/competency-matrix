package com.mrdios.competencymatrix.designpattern.patterns.creational.builder;

/**
 * 瓶装
 *
 * @author huxiong
 * @date 2017-01-22 15:12
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
