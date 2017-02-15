package com.mrdios.competencymatrix.designpattern.patterns.creational.prototype;

/**
 * @author huxiong
 * @date 2017-01-23 9:55
 */
public class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
