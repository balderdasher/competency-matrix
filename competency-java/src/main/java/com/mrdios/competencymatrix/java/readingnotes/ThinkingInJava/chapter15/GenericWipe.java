package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter15;

/**
 * 泛型擦除
 * @author huxiong
 * @date 2016/07/08 11:49
 */
class SuperMan {
    public void fly() {
        System.out.println("超人在飞...");
    }
}

class Hero<T> {
    private T someone;

    public Hero(T someone) {
        this.someone = someone;
    }

    public void savePeople() {
//        someone.fly(); // 此句不能通过编译
    }
}

class Hero2<T extends SuperMan> {
    private T someone;

    public Hero2(T someone) {
        this.someone = someone;
    }

    public void savePeople() {
        someone.fly(); // 此句通过编译
    }
}

public class GenericWipe {
    public static void main(String[] args) {
        SuperMan sm = new SuperMan();
        Hero2<SuperMan> hero = new Hero2<>(sm);
        hero.savePeople();
    }
}