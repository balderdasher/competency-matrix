package com.mrdios.competencymatrix.designpattern.patterns.structural.adapter;

/**
 * @author huxiong
 * @date 2017-01-24 10:21
 */
public class App {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc","far far away.vlc");
        audioPlayer.play("avi","teacher cang.avi");
    }
}
