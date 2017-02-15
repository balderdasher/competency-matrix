package com.mrdios.competencymatrix.designpattern.patterns.creational.builder;

/**
 * 用纸包装
 *
 * @author huxiong
 * @date 2017-01-22 15:07
 */
public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}
