package com.mrdios.competencymatrix.designpattern.patterns.structural.proxy;

/**
 * 在直接访问对象时带来的问题，比如说：要访问的对象在远程的机器上。在面向对象系统中，有些对象由于某些原因（比如对象创建开销很大，或者某些操作需要安全控制，或者需要进程外的访问），直接访问会给使用者或者系统结构带来很多麻烦，我们可以在访问此对象时加上一个对此对象的访问层。
 * <p>
 * ProxyImage 是一个代理类，减少 RealImage 对象加载的内存占用。
 *
 * @author huxiong
 * @date 2017-02-15 14:30
 */
public class App {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_image.jpg");

        // 图像从磁盘加载
        image.display();
        System.out.println("");
        // 图像将无法从磁盘加载
        image.display();
    }
}
