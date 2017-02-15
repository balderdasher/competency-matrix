package com.mrdios.competencymatrix.designpattern.patterns.creational.factory.abstractfactory;

/**
 * 创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。
 *
 * @author huxiong
 * @date 2017-01-20 16:23
 */
public class FactoryBuilder {
    public static AbstractShapAndColorFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}
