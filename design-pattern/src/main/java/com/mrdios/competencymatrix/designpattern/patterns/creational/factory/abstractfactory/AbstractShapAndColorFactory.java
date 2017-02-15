package com.mrdios.competencymatrix.designpattern.patterns.creational.factory.abstractfactory;

import com.mrdios.competencymatrix.designpattern.patterns.creational.factory.simplefactory.Shape;

/**
 * 为 Color 和 Shape 对象创建抽象类来获取工厂
 *
 * @author huxiong
 * @date 2017-01-20 16:13
 */
public abstract class AbstractShapAndColorFactory {
    abstract Shape getShap(String shapeType);

    abstract Color getColor(String color);
}
