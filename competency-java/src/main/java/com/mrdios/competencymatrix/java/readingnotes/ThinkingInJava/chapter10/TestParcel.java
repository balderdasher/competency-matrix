package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10;

/**
 * @author huxiong
 * @date 2016/06/28 12:19
 */
public class TestParcel {
    public static void main(String[] args) {
        Parcel p = new Parcel();
        Contents c = p.contents();
        Destination d = p.destination("beijing");
    }
}
