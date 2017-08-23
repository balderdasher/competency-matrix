package com.mrdios.competencymatrix.designpattern.patterns.creational.factory.abstractfactory;

import com.mrdios.competencymatrix.designpattern.patterns.creational.factory.simplefactory.Shape;

/**
 * @author huxiong
 * @date 2017-01-20 16:20
 */
public class ColorFactory extends AbstractShapAndColorFactory {
    @Override
    Shape getShap(String shapeType) {
        return null;
    }

    @Override
    Color getColor(String color) {
        if (color == null) {
            return null;
        }
        switch (color) {
            case "RED":
                return new Red();
            case "GREEN":
                return new Green();
            case "BLUE":
                return new Blue();
            default:
                throw new IllegalArgumentException("invalid color:" + color);
        }
    }
}
