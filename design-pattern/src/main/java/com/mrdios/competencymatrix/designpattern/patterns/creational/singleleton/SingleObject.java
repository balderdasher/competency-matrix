package com.mrdios.competencymatrix.designpattern.patterns.creational.singleleton;

/**
 * 单例模式定义
 *
 * @author huxiong
 * @date 2017-01-22 11:36
 */
public class SingleObject {
    private static SingleObject instance = new SingleObject();

    private SingleObject() {
    }

    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        SingleObject object = SingleObject.getInstance();
        SingleObject object1 = SingleObject.getInstance();
        object.showMessage();
        System.out.println(object == object1);//true
    }
}
