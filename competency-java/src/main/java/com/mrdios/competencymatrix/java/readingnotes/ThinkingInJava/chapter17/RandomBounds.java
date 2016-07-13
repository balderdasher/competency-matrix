package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter17;

/**
 * 验证Math.random()产生的是不是0到1的值？
 * 此实验是有误导性的，已证明Math.random()产生的范围是[0,1)
 * Created by balderdasher on 2016/7/13.
 */
public class RandomBounds {
    static void usage(String[] args) {
        if (args.length != 1) {
            System.exit(1);
        }
        if (args[0].equals("lower")) {
            while (Math.random() != 0.0) {
                System.out.println("Produced 0.0!");
            }
        } else if (args[0].equals("upper")) {
            while (Math.random() != 1.0) {
                System.out.println("Produced 1.0");
            }
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
//        usage(new String[]{"lower"});
        usage(new String[]{"upper"});
    }
}
