package com.mrdios.competencymatrix.java8.feature.function;

import java.util.function.Function;

/**
 * 函数型接口示例
 *
 * @author mrdios
 * @date 2017-08-19
 */
public class FunctionInterface {
    public static Integer convertStr2Int(String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    public static void main(String[] args) {
        Integer value = convertStr2Int("47", Integer::parseInt);
        System.out.println(value);
    }
}
