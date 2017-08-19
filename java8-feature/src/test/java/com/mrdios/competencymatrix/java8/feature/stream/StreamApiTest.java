package com.mrdios.competencymatrix.java8.feature.stream;

import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.io.File;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * StreamApi test
 *
 * @author mrdios
 * @date 2017-08-19
 */
public class StreamApiTest extends TestCase {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private List<Shop> shops = new ArrayList<>();

    public void setUp() throws Exception {
        super.setUp();
        prepareDatas();
    }

    /**
     * 查询最近的一家店铺
     *
     * @throws Exception
     */
    public void testGetNearestShop() throws Exception {
        Shop shop = StreamApi.getNearestShop(shops);
        System.out.println(shop);
    }

    /**
     * 获取符合条件的店铺
     */
    public void testGetShopsByCondition() throws Exception {
        long count = StreamApi.getShopsByCondition(shops, shop -> shop.getDistance() > 1000).size();
        System.out.println("距离大于1000的店铺数量：" + count);

        long count2 = StreamApi.getShopsByCondition(shops, shop -> shop.getName().length() > 5).size();
        System.out.println("店铺名大于5个字的店铺数：" + count2);
    }

    /**
     * 获取所有店铺名称
     *
     * @throws Exception
     */
    public void testGetAllShopName() throws Exception {
        List<String> shopNames = shops.stream()
                .sorted(Comparator.comparing(Shop::getPriceLevel).reversed())
                .map(Shop::getName)
                .collect(Collectors.toList());
        shopNames.forEach(this::print);
    }

    /**
     * 获取所有店铺的价格等级
     *
     * @throws Exception
     */
    public void testGetEachShopPriceLevel() throws Exception {
        Map<String, Integer> shopPriceDesc = shops.stream()
                .sorted(Comparator.comparing(Shop::getPriceLevel).reversed())
                .collect(Collectors.toConcurrentMap(Shop::getName, Shop::getPriceLevel));
        print(shopPriceDesc);
        shopPriceDesc.forEach((s, integer) -> System.out.println(s + ":" + integer));
    }

    /**
     * 店铺按价格等级分组
     */
    public void testAllPriceLevelShopList() throws Exception {
        Map<Integer, List<Shop>> priceMap = shops.stream()
                .collect(Collectors.groupingBy(Shop::getPriceLevel));
        print(priceMap);
    }

    /**
     * 串行和并行
     *
     * @throws Exception
     */
    public void testParallelStream() throws Exception {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            list.add(random.nextInt(10000000));
        }
        StopWatch timer = new StopWatch();
        timer.start();
        list.stream()
                .filter(n -> n > 999999)
                .sorted(Comparator.comparingInt(o -> o))
                .limit(9999999)
                .collect(Collectors.toList());
        timer.stop();
        System.out.println("串行耗时：" + timer.getTotalTimeSeconds());


        StopWatch timer2 = new StopWatch();
        timer2.start();
        list.parallelStream()
                .filter(n -> n > 999999)
                .sorted(Comparator.comparingInt(o -> o))
                .limit(9999999)
                .collect(Collectors.toList());
        timer2.stop();
        System.out.println("并行耗时：" + timer.getTotalTimeSeconds());
    }


    private void prepareDatas() {
        System.out.println("组装数据.....");
        Shop p1 = new Shop("叫了个鸡", 1000, 500, 2);
        Shop p2 = new Shop("张三丰饺子馆", 2300, 1500, 3);
        Shop p3 = new Shop("永和大王", 580, 3000, 1);
        Shop p4 = new Shop("肯德基", 6000, 200, 4);
        shops = Arrays.asList(p1, p2, p3, p4);
    }

    /**
     * 获取文件夹下某类型的文件名
     *
     * @throws Exception
     */
    @SuppressWarnings("ConstantConditions")
    public void testListAllAviFiles() throws Exception {
        List<String> files = Arrays.stream((Paths.get("F:\\影音娱乐")).toFile().listFiles())
                .filter(file -> file.getName().endsWith(".mp4"))
                .map(File::getName)
                .collect(Collectors.toList());
        files.forEach(this::print);

        Arrays.stream(Paths.get("K:\\电影").toFile()
                .listFiles((dir, name) -> name.endsWith(".rmvb"))).forEach(file -> System.out.println(file.getName()));

    }

    private void print(Object object) {
        System.out.println(object);
    }

}