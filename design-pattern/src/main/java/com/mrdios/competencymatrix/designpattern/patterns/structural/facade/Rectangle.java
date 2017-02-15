package com.mrdios.competencymatrix.designpattern.patterns.structural.facade;

/**
 * @author huxiong
 * @date 2017-02-15 10:25
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}
