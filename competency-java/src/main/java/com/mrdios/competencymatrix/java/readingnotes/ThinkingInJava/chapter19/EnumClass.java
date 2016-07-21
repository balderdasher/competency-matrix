package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter19;

/**
 * 枚举类功能演示
 * Created by mrdios on 2016/7/21.
 */
public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s:Shrubbery.values()){
            // 值在定义时候的顺序,从0开始
            System.out.println(s + " ordinal: " + s.ordinal());
            // enum类实现了Comparable接口，还实现了Serializable接口
            System.out.println(s.compareTo(Shrubbery.CRAWLING));
            // 使用==来比较enum实例，equals()和hashCode()方法由编译器自动提供
            System.out.println(s == Shrubbery.CRAWLING);
            System.out.println(s.equals(Shrubbery.CRAWLING));
            // 通过调用getDeclaringClass得到实例所在的enum类
            System.out.println(s.getDeclaringClass().getSimpleName());
            System.out.println(s.name());
            System.out.println("----------------------");
        }
        // 从一个字符串构造一个枚举
        for (String s:"HANGING CRAWLING GROUND".split(" ")){
            Shrubbery shrub = Enum.valueOf(Shrubbery.class,s);
            System.out.println(shrub);
        }
    }
}

enum Shrubbery{GROUND,CRAWLING,HANGING}
