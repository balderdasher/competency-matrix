package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter9.adapter;

/**
 * 滤波器父类
 * @author huxiong
 * @date 2016/06/27 16:43
 */
public class Filter {
    public String name(){
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input){
        return input;
    }
}
