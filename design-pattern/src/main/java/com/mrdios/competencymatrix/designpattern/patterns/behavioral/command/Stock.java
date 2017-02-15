package com.mrdios.competencymatrix.designpattern.patterns.behavioral.command;

/**
 * 一个请求类
 *
 * @author huxiong
 * @date 2017-02-15 16:54
 */
public class Stock {
    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: " + name + ",Quantity: " + quantity + " ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ",Quantity: " + quantity + " ] sold");
    }
}
