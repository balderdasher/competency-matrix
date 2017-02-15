package com.mrdios.competencymatrix.designpattern.patterns.creational.prototype;

/**
 * 使用 ShapeCache 类来获取存储在 Hashtable 中的形状的克隆
 *
 * @author huxiong
 * @date 2017-01-23 10:04
 */
public class App {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape circle = ShapeCache.getShape("1");
        System.out.println("Shape : " + circle.getType());

        Shape square = ShapeCache.getShape("2");
        System.out.println("Shape : " + square.getType());

        Shape rectangle = ShapeCache.getShape("3");
        System.out.println("Shape : " + rectangle.getType());
    }
}
