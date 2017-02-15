package com.mrdios.competencymatrix.designpattern.patterns.creational.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 套餐类
 *
 * @author huxiong
 * @date 2017-01-22 15:27
 */
public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }

}
