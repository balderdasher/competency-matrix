package com.mrdios.competencymatrix.designpattern.patterns.creational.decorator.theory;

/**
 * 具体装饰是装饰的一个非抽象子类，具体装饰的实例称为“装饰者“。
 *
 * @author huxiong
 * @date 2017-01-19 11:48
 */
public class ConcreteDecoratorB extends Decorator {
    @Override
    public void methodA() {
        super.methodA();
    }

    @Override
    public void methodB() {
        super.methodB();
    }

    public void otherMethod() {
    }
}
