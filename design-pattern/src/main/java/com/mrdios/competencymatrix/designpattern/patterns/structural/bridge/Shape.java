package com.mrdios.competencymatrix.designpattern.patterns.structural.bridge;

/**
 * @author huxiong
 * @date 2017-01-24 14:14
 */
public abstract class Shape {
    protected DrawApi drawApi;

    protected Shape(DrawApi drawApi) {
        this.drawApi = drawApi;
    }

    public abstract void draw();
}
