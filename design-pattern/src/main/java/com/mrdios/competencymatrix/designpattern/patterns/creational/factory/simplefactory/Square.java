package com.mrdios.competencymatrix.designpattern.patterns.creational.factory.simplefactory;

/**
 * step2:create concrete product class implements product interface
 *
 * @author huxiong
 * @date 2017-01-20 11:05
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
