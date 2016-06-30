package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10;

/**
 * .new 的使用
 * @author huxiong
 * @date 2016/06/28 11:17
 */
public class DotNew {
    public class Inner{}

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner();
    }
}
