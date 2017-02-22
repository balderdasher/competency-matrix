package com.mrdios.competencymatrix.designpattern.patterns.behavioral.strategy;

/**
 * @author huxiong
 * @date 2017-02-22 15:03
 */
public class DownCase implements Processor {
    @Override
    public Object process(Object input) {
        return ((String) input).toLowerCase();
    }
}
