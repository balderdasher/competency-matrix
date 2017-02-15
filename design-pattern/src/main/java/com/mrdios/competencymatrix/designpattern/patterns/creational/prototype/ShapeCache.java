package com.mrdios.competencymatrix.designpattern.patterns.creational.prototype;

import java.util.Hashtable;

/**
 * 从数据库获取实体类，并把它们存储在一个 Hashtable 中。
 *
 * @author huxiong
 * @date 2017-01-23 9:56
 */
public class ShapeCache {
    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        Square square = new Square();
        Rectangle rectangle = new Rectangle();
        circle.setId("1");
        square.setId("2");
        rectangle.setId("3");

        shapeMap.put(circle.getId(), circle);
        shapeMap.put(square.getId(), square);
        shapeMap.put(rectangle.getId(), rectangle);

    }
}
