package com.mrdios.competencymatrix.designpattern.patterns.structural.bridge;

/**
 * @author huxiong
 * @date 2017-01-24 14:18
 */
public class Circle extends Shape {
    private int x, y, radius;

    protected Circle(int x, int y, int radius, DrawApi drawApi) {
        super(drawApi);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawApi.drawCircle(radius, x, y);
    }
}
