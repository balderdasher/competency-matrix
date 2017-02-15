package com.mrdios.competencymatrix.designpattern.patterns.creational.factory.abstractfactory;

/**
 * @author huxiong
 * @date 2017-01-20 16:10
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
