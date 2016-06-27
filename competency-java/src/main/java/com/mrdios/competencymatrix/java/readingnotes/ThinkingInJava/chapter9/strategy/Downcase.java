package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter9.strategy;

/**
 * 小写转换处理类
 * @author huxiong
 * @date 2016/06/27 15:53
 */
public class Downcase extends Processor{
    @Override
    String process(Object input) {
        return ((String)input).toLowerCase();
    }
}
