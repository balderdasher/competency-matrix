package com.mrdios.competencymatrix.designpattern.patterns.structural.adapter;

/**
 * 高级播放器接口
 *
 * @author huxiong
 * @date 2017-01-24 10:11
 */
public interface AdvanceMediaPlayer {
    void playVlc(String fileName);

    void playMp4(String fileName);
}
