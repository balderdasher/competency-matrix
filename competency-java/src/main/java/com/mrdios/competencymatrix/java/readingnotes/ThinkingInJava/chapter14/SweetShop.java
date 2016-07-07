package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter14;

/**
 * @author huxiong
 * @date 2016/07/05 11:16
 */
class Candy {
    static{
        System.out.println("Loading Candy");
    }
}

class Cookie {
    static{
        System.out.println("Loading Cookie");
    }
}

class Gum {
    static{
        System.out.println("Loading Gum");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class.forName("com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter14.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}
