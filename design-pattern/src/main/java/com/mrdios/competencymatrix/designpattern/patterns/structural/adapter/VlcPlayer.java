package com.mrdios.competencymatrix.designpattern.patterns.structural.adapter;

/**
 * @author huxiong
 * @date 2017-01-24 10:12
 */
public class VlcPlayer implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // do nothing
    }
}
