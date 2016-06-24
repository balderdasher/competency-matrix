package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter3;

/**
 * 移位操作符
 * ps:左移相当于左边的数*2的右边数次方，右移相当于除以2的右边数的次方
 * 如:m<<n等于m乘以2的n次方；m>>n等于m除以2的n次方
 * Created by balderdasher on 2016/6/16.
 */
public class MoveBitOpt {
    public static void main(String[] args) {
        int i = 4;
        int pos = 2;
        System.out.println("before move: " + Integer.toBinaryString(i));
        moveLeft(i, pos);
        moveRight(i, pos);
    }

    /**
     * 左移
     *
     * @param i
     * @param pos
     */
    public static void moveLeft(int i, int pos) {
        i <<= pos;
        System.out.println("after left move: " + Integer.toBinaryString(i));
        System.out.println(i);
    }

    /**
     * 右移
     *
     * @param i
     * @param pos
     */
    public static void moveRight(int i, int pos) {
        i >>= pos;
        System.out.println("after right move: " + Integer.toBinaryString(i));
        System.out.println(i);
    }
}
