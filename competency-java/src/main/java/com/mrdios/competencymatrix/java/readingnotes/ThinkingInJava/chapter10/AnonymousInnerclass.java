package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10;

/**
 * 匿名内部类
 *
 * @author huxiong
 * @date 2016/06/28 12:46
 */
public class AnonymousInnerclass {

    // 不使用匿名内部类时要定义的内部类
    class MyContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    public Contents contents() {
//        return new MyContents();
        return new Contents() {
            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        AnonymousInnerclass aic = new AnonymousInnerclass();
        aic.contents();
    }
}
