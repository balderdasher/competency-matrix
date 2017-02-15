package com.mrdios.competencymatrix.designpattern.patterns.creational.factory.simplefactory;

/**
 * @author huxiong
 * @date 2017-01-20 11:16
 */
public class App {
    public static void main(String[] args) {
        Shape circle = ShapFactory.getShap("CIRCLE");
        circle.draw();

        Shape rectangle = ShapFactory.getShap("RECTANGLE");
        rectangle.draw();

        Shape square = ShapFactory.getShap("SQUARE");
        square.draw();

    }

}
