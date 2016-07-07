package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter14.proxy;

/**
 * 简单的代理设计模式
 * @author huxiong
 * @date 2016/07/05 15:45
 */
interface Interface {
    void doSomething();

    void somethingEsle(String arg);
}

class RealObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingEsle(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface{

    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingEsle(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingEsle(arg);
    }
}

class SimpleProxyDemo{
    public static void consumer(Interface face){
        face.doSomething();
        face.somethingEsle("billie");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
