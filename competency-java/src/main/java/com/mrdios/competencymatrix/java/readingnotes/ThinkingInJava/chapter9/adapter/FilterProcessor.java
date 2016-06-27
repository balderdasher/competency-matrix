package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter9.adapter;

/**
 * @author huxiong
 * @date 2016/06/27 16:54
 */
public class FilterProcessor {
    public static void main(String[] args) {
        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)),w);
        Apply.process(new FilterAdapter(new HighPass(2.0)),w);
    }
}
