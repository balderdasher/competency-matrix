package com.mrdios.competencymatrix.designpattern.patterns.creational.factory.abstractfactory;

import com.mrdios.competencymatrix.designpattern.patterns.creational.factory.simplefactory.Circle;
import com.mrdios.competencymatrix.designpattern.patterns.creational.factory.simplefactory.Rectangle;
import com.mrdios.competencymatrix.designpattern.patterns.creational.factory.simplefactory.Shape;
import com.mrdios.competencymatrix.designpattern.patterns.creational.factory.simplefactory.Square;

/**
 * @author huxiong
 * @date 2017-01-20 16:15
 */
public class ShapFactory extends AbstractShapAndColorFactory {
    @Override
    public Shape getShap(String shapeType) {
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
                throw new IllegalArgumentException("invalid shape:" + shapeType);
        }
    }

    @Override
    Color getColor(String color) {
        return null;
    }
}
