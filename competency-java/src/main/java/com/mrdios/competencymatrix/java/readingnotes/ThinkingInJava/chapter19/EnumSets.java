package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter19;

import java.util.EnumSet;

/**
 * EnumSet跟踪警报器状态
 * Created by mrdios on 2016/7/21.
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class); // empty set
        points.add(AlarmPoints.BATHROOM);
        System.out.println(points);
        points.addAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        System.out.println(points);
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        System.out.println(points);
        points.removeAll(EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));
        System.out.println(points);
        points = EnumSet.complementOf(points);//取补集
        System.out.println(points);
    }
}
