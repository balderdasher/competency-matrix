package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter3;

/**
 * Created by balderdasher on 2016/6/16.
 */
public class JavaParamPassTest {
    public static void main(String[] args)

    {
        StringBuffer s = new StringBuffer("good");
        StringBuffer s2 = new StringBuffer("bad");
        test(s, s2);
//        test2(s,s2);
        System.out.println(9 + ": " + s);//9
        System.out.println(10 + ": " + s2);//10
    }


    static void test(StringBuffer p1, StringBuffer p2) {
        System.out.println(p1);//1
        System.out.println(p2);//2
        p2 = p1;//3
        p1 = new StringBuffer("new");//4
        System.out.println(5 + ": " + p1);//5
        System.out.println(6 + ": " + p2);//6
        p1.append("hah");//7
        p2.append("hah");//8
    }

    static void test2(StringBuffer s1,StringBuffer s2){
        s1.append("one");
        s2.append("two");
    }

}
