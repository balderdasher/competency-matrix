package com.mrdios.competencymatrix.designpattern.patterns.creational.builder;

/**
 * Step 1：建一个表示食物条目和食物包装的接口。
 *
 * @author huxiong
 * @date 2017-01-22 15:01
 */
public interface Item {
    public String name();

    public Packing packing();

    public float price();
}
