package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter19;

/**
 * switch语句中的enum
 * Created by mrdios on 2016/7/21.
 */
enum Signal {
    GREEN, YELLOW, RED
}

public class TrafficLight {
    Signal color = Signal.RED;
    public void change() {
        switch (color) {
            // 在case语句中不必使用enum类型来修饰一个enum实例如此处不必用Signal.RED
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}
