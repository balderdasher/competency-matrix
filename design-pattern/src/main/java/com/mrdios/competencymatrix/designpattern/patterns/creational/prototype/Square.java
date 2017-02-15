package com.mrdios.competencymatrix.designpattern.patterns.creational.prototype;

/**
 * @author huxiong
 * @date 2017-01-23 9:54
 */
public class Square extends Shape {
    public Square() {
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
