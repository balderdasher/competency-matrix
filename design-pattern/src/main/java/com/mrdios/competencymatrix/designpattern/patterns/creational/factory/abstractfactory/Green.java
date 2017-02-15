package com.mrdios.competencymatrix.designpattern.patterns.creational.factory.abstractfactory;

/**
 * @author huxiong
 * @date 2017-01-20 16:11
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
