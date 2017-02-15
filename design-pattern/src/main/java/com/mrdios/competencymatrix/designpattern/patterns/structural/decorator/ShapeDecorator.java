package com.mrdios.competencymatrix.designpattern.patterns.structural.decorator;

/**
 * 实现了 Shape 接口的抽象装饰类
 *
 * @author huxiong
 * @date 2017-01-25 11:44
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
