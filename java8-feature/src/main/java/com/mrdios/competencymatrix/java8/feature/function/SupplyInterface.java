package com.mrdios.competencymatrix.java8.feature.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 供给型接口示例
 *
 * @author mrdios
 * @date 2017-08-19
 */
public class SupplyInterface {
    public static List<Integer> supply(Integer num, Supplier<Integer> supplier) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            resultList.add(supplier.get());
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> list = supply(10, () -> (int) (Math.random() * 100));
        list.forEach(System.out::println);
    }
}
