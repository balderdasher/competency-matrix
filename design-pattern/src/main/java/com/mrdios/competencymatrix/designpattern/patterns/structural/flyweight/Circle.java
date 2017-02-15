package com.mrdios.competencymatrix.designpattern.patterns.structural.flyweight;

/**
 * @author huxiong
 * @date 2017-02-15 10:34
 */
public class Circle implements Shape {
    private String color;
    private int x;
    private int y;
    private int radius;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Circle: draw() [Color : " + color
                + ", x : " + x + ", y : " + y + ", radius : " + radius + "]");
    }
}
