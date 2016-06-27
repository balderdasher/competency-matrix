package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter9.adapter;

/**
 * 滤波器适配器
 * @author huxiong
 * @date 2016/06/27 16:49
 */
public class FilterAdapter implements Processor{
    Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Object process(Object input) {
        return filter.process((Waveform) input);
    }
}
