package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter9.adapter;

/**
 * @author huxiong
 * @date 2016/06/27 16:47
 */
public class LowPass extends Filter{
    double cutoff;
    public LowPass(double cutoff){
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
