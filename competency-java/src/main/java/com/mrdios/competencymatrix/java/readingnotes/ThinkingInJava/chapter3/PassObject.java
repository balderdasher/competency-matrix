package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter3;


import com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter3.model.Tank;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法调用时的别名现象
 * Created by balderdasher on 2016/6/15.
 */
public class PassObject {
    public static void f(Tank tank) {
        tank.setLevel(47);
    }

    public static void main(String[] args) {
        Tank tank1 = new Tank();
        Tank tank2 = new Tank();
        test2(tank1, tank2);
        System.out.println("tank1.level: " + tank1.getLevel());
        System.out.println("tank2.level: " + tank2.getLevel());
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        test3(list);
        System.out.println("list.size: " + list.size());
        int val = 67;
        test4(val);
        System.out.println(val);
        String before = "before";
        testPassString(before);
        System.out.println(before);

    }

    static void test1(Tank tank) {
        tank.setLevel(9);
        System.out.println("1:tank.level: " + tank.getLevel());
        f(tank);
        System.out.println("2:tank.level: " + tank.getLevel());
    }

    static void test2(Tank t1, Tank t2) {
        t1.setLevel(1);
        t2.setLevel(2);
    }

    static void test3(List list) {
        if (list.size() > 0) {
            list.remove(0);
        }
    }

    static void test4(int val) {
        val = 89;
    }

    static void testPassString(String param){
        param = "after";
    }
}
