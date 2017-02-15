package com.mrdios.competencymatrix.designpattern.patterns.structural.decorator;

/**
 * 具体装饰器
 *
 * @author huxiong
 * @date 2017-01-25 11:45
 */
public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder();
    }

    private void setRedBorder() {
        System.out.println("Border Color: Red");
    }
}
