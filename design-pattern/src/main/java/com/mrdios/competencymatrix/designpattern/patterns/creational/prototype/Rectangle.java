package com.mrdios.competencymatrix.designpattern.patterns.creational.prototype;

/**
 * @author huxiong
 * @date 2017-01-23 9:53
 */
public class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
