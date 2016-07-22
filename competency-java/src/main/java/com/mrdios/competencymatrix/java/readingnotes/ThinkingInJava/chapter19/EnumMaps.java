package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter19;

import java.util.EnumMap;
import java.util.Map;

/**
 * 使用EnumMap
 * Created by mrdios on 2016/7/22.
 */
interface Command{void action();}

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints,Command> em = new EnumMap<>(AlarmPoints.class);
        em.put(AlarmPoints.KITCHEN, new Command() {
            @Override
            public void action() {
                System.out.println("厨房着火了");
            }
        });
        em.put(AlarmPoints.BATHROOM, new Command() {
            @Override
            public void action() {
                System.out.println("浴室起火了");
            }
        });
        for (Map.Entry<AlarmPoints,Command> e:em.entrySet()){
            System.out.println(e.getKey());
            e.getValue().action();
        }
        try {
            em.get(AlarmPoints.UTILITY).action();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
