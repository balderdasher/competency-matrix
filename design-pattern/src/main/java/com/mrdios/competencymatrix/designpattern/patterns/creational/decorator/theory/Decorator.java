package com.mrdios.competencymatrix.designpattern.patterns.creational.decorator.theory;

/**
 * 装饰也是抽象组件的一个子类，但装饰还包含一个抽象组件声明的变量以保存“被装饰者“的引用。
 * 装饰可以是一个抽象类也可以是一个非抽象类，如果是非抽象类，该类的实例称为”装饰者“。
 *
 * @author huxiong
 * @date 2017-01-19 11:46
 */
public class Decorator extends Component {
    public Component component;

    @Override
    public void methodB() {
        super.methodB();
    }

    @Override
    public void methodA() {
        super.methodA();
    }
}
