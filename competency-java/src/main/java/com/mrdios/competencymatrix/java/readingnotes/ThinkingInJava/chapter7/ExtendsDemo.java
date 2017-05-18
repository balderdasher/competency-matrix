package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter7;

/**
 * @author huxiong
 * @date 2017-05-15 17:19
 */
public class ExtendsDemo {
    public static void main(String[] args) {
        Son son = new Son();
    }
}

class Grandpa {
    public Grandpa() {
        System.out.println("Grandpa: 我是你爷爷");
    }
}

class Dad extends Grandpa {
    public Dad() {
        System.out.println("Dad: 我是你爹");
    }
}

class Son extends Dad {
    public Son() {
        System.out.println("Son: 我是尼古拉斯.赵四");
    }
}
