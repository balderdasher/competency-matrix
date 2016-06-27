package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter9.adapter;

/**
 * 滤波
 * @author huxiong
 * @date 2016/06/27 16:42
 */
public class Waveform {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "waveform " + id;
    }
}
