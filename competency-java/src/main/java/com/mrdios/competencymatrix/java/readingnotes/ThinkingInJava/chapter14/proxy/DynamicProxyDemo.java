package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter14.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author huxiong
 * @date 2016/07/05 16:17
 */
class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ". method：" + method + ". args：" + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println("  " + arg);
            }
        }
        return method.invoke(proxied, args);
    }
}

class DynamicProxyDemo {
    public static void consumer(Interface face) {
        face.doSomething();
        face.somethingEsle("billie");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // 创建动态代理
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
