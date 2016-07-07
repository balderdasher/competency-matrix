package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter15;

/**
 * 泛型类
 *
 * @author huxiong
 * @date 2016/07/07 15:17
 */
public class GenericClass<T> {
    private T field;

    public T getField() {
        return field;
    }

    public void setField(T field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "GenericClass{" +
                "field=" + field +
                '}';
    }

    public static void main(String[] args) {
        GenericClass<String> s = new GenericClass<>();
        s.setField("gaga");
        System.out.println("s：" + s);
        GenericClass<Integer> i = new GenericClass<>();
        i.setField(100);
        System.out.println("i：" + i);
    }
}
