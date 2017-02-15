package com.mrdios.competencymatrix.designpattern.patterns.creational.factory.simplefactory;

/**
 * step3:创建工厂类，生成基于给定信息的具体产品类的对象
 * 简单工厂模式|静态工厂方法模式
 *
 * @author huxiong
 * @date 2017-01-20 11:10
 */
public class ShapFactory {
    public static Shape getShap(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        switch (shapeType) {
            case "CIRCLE":
                return new Circle();
            case "RECTANGLE":
                return new Rectangle();
            case "SQUARE":
                return new Square();
            default:
                return null;
        }
    }
}
