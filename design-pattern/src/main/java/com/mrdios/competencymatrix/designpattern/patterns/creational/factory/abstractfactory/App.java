package com.mrdios.competencymatrix.designpattern.patterns.creational.factory.abstractfactory;

import com.mrdios.competencymatrix.designpattern.patterns.creational.factory.simplefactory.Shape;

/**
 * @author huxiong
 * @date 2017-01-20 16:26
 */
public class App {
    public static void main(String[] args) {
        AbstractShapAndColorFactory shapeFactory = FactoryBuilder.getFactory("SHAPE");
        Shape circle = shapeFactory.getShap("CIRCLE");
        circle.draw();

        AbstractShapAndColorFactory colorFactory = FactoryBuilder.getFactory("COLOR");
        Color red = colorFactory.getColor("RED");
        red.fill();
    }
}
