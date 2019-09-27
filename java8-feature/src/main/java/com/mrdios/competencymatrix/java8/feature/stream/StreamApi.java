package com.mrdios.competencymatrix.java8.feature.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author mrdios
 * @date 2017-08-19
 */
public class StreamApi {

    private static final Logger logger = LoggerFactory.getLogger(StreamApi.class);

    /**
     * 获取距离最近的店铺
     *
     * @param shops
     * @return 距离最近的Shop
     */
    @SuppressWarnings("ConstantConditions")
    public static Shop getNearestShop(List<Shop> shops) {
        return shops.stream()
                .sorted(Comparator.comparingInt(Shop::getDistance))
                .findFirst()
                .get();
    }

    /**
     * 筛选符合条件的店铺
     *
     * @param shops     店铺列表
     * @param predicate 限定条件
     * @return 符合条件的店铺
     */
    public static List<Shop> getShopsByCondition(List<Shop> shops, Predicate<Shop> predicate) {
        return shops.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        logger.info("gentlegagta");
    }
}
