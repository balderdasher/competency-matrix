package com.mrdios.competencymatrix.java8.feature.stream;

/**
 * 外卖店铺
 *
 * @author mrdios
 * @date 2017-08-19
 */
public class Shop {
    private String name;
    private Integer distance;
    private Integer sales;
    private Integer priceLevel;

    public Shop(String name, Integer distance, Integer sales, Integer priceLevel) {
        this.name = name;
        this.distance = distance;
        this.sales = sales;
        this.priceLevel = priceLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(Integer priceLevel) {
        this.priceLevel = priceLevel;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                ", sales=" + sales +
                ", priceLevel=" + priceLevel +
                '}';
    }
}
