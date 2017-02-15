package com.mrdios.competencymatrix.designpattern.patterns.creational.factory.abstractfactory;

/**
 * @author huxiong
 * @date 2017-01-20 16:12
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::file() method.");
    }
}
