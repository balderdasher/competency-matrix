package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter19;

/**
 * 接口组织枚举，实现接口是enum子类化的唯一办法
 * Created by mrdios on 2016/7/21.
 */
public class GoodsType {
    public static void main(String[] args) {
        Goods goods = Goods.Office.COMPUTER;
        goods = Goods.Food.FRUIT;
        goods = Goods.Book.TECHNOLOGY;
    }
}
interface Goods {
    enum Office implements Goods {COMPUTER, GAME;}
    enum Food implements Goods {FRUIT, SEAFOOD, MEAT, WINE}
    enum Book implements Goods {LIFE, EDUCATION, TECHNOLOGY}
}
