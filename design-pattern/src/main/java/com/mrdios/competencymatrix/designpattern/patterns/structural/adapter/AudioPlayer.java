package com.mrdios.competencymatrix.designpattern.patterns.structural.adapter;

/**
 * @author huxiong
 * @date 2017-01-24 10:18
 */
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if ("mp3".equalsIgnoreCase(audioType)) {
            System.out.println("Playing mp3 file. name: " + fileName);
        } else if ("vlc".equalsIgnoreCase(audioType)
                || "mp4".equalsIgnoreCase(audioType)) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + "format not supported");
        }
    }
}
