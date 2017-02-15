package com.mrdios.competencymatrix.designpattern.patterns.structural.adapter;

/**
 * @author huxiong
 * @date 2017-01-24 10:13
 */
public class Mp4Player implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. name: " + fileName);
    }
}
