package com.mrdios.competencymatrix.java8.feature.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 断言型接口示例
 *
 * @author mrdios
 * @date 2017-08-19
 */
public class PredicateInterface {
    public static List<String> filter(List<String> fruits, Predicate<String> predicate) {
        List<String> result = new ArrayList<>();
        for (String fruit : fruits
                ) {
            if (predicate.test(fruit)) {
                result.add(fruit);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("香蕉", "哈密瓜", "榴莲", "火龙果", "水蜜桃");
        List<String> result = filter(fruits, fruit -> fruit.length() == 2);
        System.out.println(result);
    }
}
