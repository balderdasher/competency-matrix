package com.mrdios.competencymatrix.designpattern.patterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令调用类
 *
 * @author huxiong
 * @date 2017-02-15 16:58
 */
public class Broker {
    private List<Order> orders = new ArrayList<>();

    public void takeOrder(Order order) {
        orders.add(order);
    }

    public void placeOrder() {
        for (Order order :
                orders) {
            order.execute();
        }
        orders.clear();
    }
}
