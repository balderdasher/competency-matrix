package com.mrdios.competencymatrix.designpattern.patterns.behavioral.strategy;

/**
 * 策略接口，使各种策略可以相互替换
 *
 * @author huxiong
 * @date 2017-02-22 15:00
 */
public interface Processor {
    Object process(Object input);
}
