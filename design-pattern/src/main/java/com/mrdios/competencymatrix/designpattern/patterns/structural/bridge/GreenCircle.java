package com.mrdios.competencymatrix.designpattern.patterns.structural.bridge;

/**
 * @author huxiong
 * @date 2017-01-24 14:13
 */
public class GreenCircle implements DrawApi {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green,radius: " + radius + ", x: " + x + ", y: " + y + "]");
    }
}
