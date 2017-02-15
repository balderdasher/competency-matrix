package com.mrdios.competencymatrix.designpattern.patterns.structural.facade;

/**
 * 画图的外观类
 *
 * @author huxiong
 * @date 2017-02-15 10:26
 */
public class ShapeMakerFacade {
    private Shape circle;
    private Shape rectangle;

    public ShapeMakerFacade() {
        circle = new Circle();
        rectangle = new Rectangle();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }
}
