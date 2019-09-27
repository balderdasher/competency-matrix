package com.mrdios.competencymatrix.designpattern.patterns.creational.factory.simplefactory;

/**
 * 通过反射优化简单工厂模式，省去新增产品时都要修改获取产品的逻辑,使用时需要强转为具体类型
 *
 * @author CodePorter
 * @date 2018-01-15
 */
public class AdvanceShapFactory {
    public static Object getShape(Class<? extends Shape> shapeClass) {
        Object shape = null;
        try {
            shape = Class.forName(shapeClass.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return shape;
    }

    public static void main(String[] args) {
        Shape circle = (Circle) AdvanceShapFactory.getShape(Circle.class);
        circle.draw();
    }
}
