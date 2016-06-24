package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter3;


import com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter3.model.Tank;

/**
 * 对象赋值的别名现象
 * 对象的赋值操作是将引用从一个地方复制到另一个地方，修改其中一个对象将影响另一个
 * Created by balderdasher on 2016/6/15.
 */
public class Assignment {
    public static void main(String[] args) {
        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.setLevel(9);
        t2.setLevel(47);
        System.out.println("赋值前:t1.level: " + t1.getLevel() + ", t2.level: " + t2.getLevel());
        t1 = t2;
        System.out.println("赋值后:t1.level: " + t1.getLevel() + ", t2.level: " + t2.getLevel());
        t1.setLevel(27);
        System.out.println("改变后:t1.level: " + t1.getLevel() + ", t2.level: " + t2.getLevel());
    }
}
