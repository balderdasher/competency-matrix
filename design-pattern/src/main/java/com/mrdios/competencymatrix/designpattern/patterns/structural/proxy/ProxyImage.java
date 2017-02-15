package com.mrdios.competencymatrix.designpattern.patterns.structural.proxy;

/**
 * @author huxiong
 * @date 2017-02-15 14:28
 */
public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
