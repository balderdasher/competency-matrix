package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author huxiong
 * @date 2016/07/01 14:40
 */
public class PattenUseExample {
    public static void main(String[] args) {
        String regex = "(Java)?+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher("Java");
        System.out.println(m.matches());
    }
}
