package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 遵循指导的一个hashCode()实现
 * Created by balderdasher on 2016/7/13.
 */
public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;

    public CountedString(String s) {
        this.s = s;
        created.add(s);
        // id 为此String在CountedString中使用的实例总数
        for (String s1 : created) {
            if (s1.equals(s)) {
                id++;
            }
        }
    }

    @Override
    public String toString() {
        return "String：" + s + " id：" + id + " hashCode()：" + hashCode();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CountedString &&
                s.equals(((CountedString) obj).s) &&
                id == ((CountedString) obj).id;
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);
        }
        System.out.println(map);
        for (CountedString cstring : cs) {
            System.out.println("Looking up " + cstring);
            System.out.println(map.get(cstring));
        }
    }
}
