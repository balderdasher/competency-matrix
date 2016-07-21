package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter19;

/**
 * enum中添加新方法
 * Created by mrdios on 2016/7/21.
 */
public enum OfferType {
    // 实例的定义必须在最方法或者属性之前，否则会编译错误
    FOOD("美食"),
    HAPPY("娱乐"),
    STAY("住宿"),
    SHOPPING("购物"),
    TRIP("出行"),
    LIFE("生活服务"),
    OTHER("其它");

    private String desc;

    // 构造器必须是private的或者是包访问权限(ide已建议为包访问权限)的
    OfferType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    // enum中可以有main()方法
    public static void main(String[] args) {
        for (OfferType o : OfferType.values()) {
            System.out.println(o + ": " + o.getDesc());
        }
    }
}
