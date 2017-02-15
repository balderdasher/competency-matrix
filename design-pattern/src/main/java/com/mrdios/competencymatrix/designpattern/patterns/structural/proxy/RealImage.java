package com.mrdios.competencymatrix.designpattern.patterns.structural.proxy;

/**
 * @author huxiong
 * @date 2017-02-15 14:26
 */
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }
}
