package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter3.model;

/**
 * Created by balderdasher on 2016/6/15.
 */
public class Tank {
    private int level;
    private String aa;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "level=" + level +
                ", aa='" + aa + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Tank t = new Tank();
        System.out.println(t.toString());
    }
}
