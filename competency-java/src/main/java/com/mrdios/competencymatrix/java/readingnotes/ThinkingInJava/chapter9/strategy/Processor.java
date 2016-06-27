package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter9.strategy;

/**
 * 处理器类
 *
 * @author huxiong
 * @date 2016/06/27 15:43
 */
public class Processor {
    /**
     * 用于返回处理器名字
     *
     * @return
     */
    public String name() {
        return getClass().getSimpleName();
    }

    /**
     * 处理方法，接收参数并处理然后返回，返回类型可以是协变类型
     * @param input
     * @return
     */
    Object process(Object input) {
        return input;
    }
}
