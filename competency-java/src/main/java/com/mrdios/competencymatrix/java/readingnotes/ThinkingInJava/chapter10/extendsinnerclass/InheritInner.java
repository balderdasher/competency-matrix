package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10.extendsinnerclass;

/**
 * 继承内部类
 * @author huxiong
 * @date 2016/06/28 23:52
 */
public class InheritInner extends WithInner.Inner {
    public InheritInner(WithInner wi) {
        wi.super();
    }

    @Override
    public void say() {
        super.say();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
        ii.say();

    }
}
