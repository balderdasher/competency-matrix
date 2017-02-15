package com.mrdios.competencymatrix.designpattern.patterns.structural.decorator;

/**
 * @author huxiong
 * @date 2017-01-25 11:42
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape:: Rectangle");
    }
}
