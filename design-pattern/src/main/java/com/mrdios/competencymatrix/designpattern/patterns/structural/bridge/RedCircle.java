package com.mrdios.competencymatrix.designpattern.patterns.structural.bridge;

/**
 * 实现了 DrawAPI 接口的实体桥接实现类
 *
 * @author huxiong
 * @date 2017-01-24 14:11
 */
public class RedCircle implements DrawApi {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red,radius: " + radius + ", x: " + x + ", y: " + y + "]");
    }
}
