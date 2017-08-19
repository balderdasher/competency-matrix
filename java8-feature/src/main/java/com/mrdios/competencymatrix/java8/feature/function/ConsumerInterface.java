package com.mrdios.competencymatrix.java8.feature.function;

import java.util.function.Consumer;

/**
 * 消费型借口示例
 *
 * @author mrdios
 * @date 2017-08-19
 */
public class ConsumerInterface {
    public static void donation(Integer money, Consumer<Integer> consumer) {
        consumer.accept(money);
    }
}
