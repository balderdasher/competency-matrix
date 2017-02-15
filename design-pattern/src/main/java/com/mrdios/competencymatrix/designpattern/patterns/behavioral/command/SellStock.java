package com.mrdios.competencymatrix.designpattern.patterns.behavioral.command;

/**
 * @author huxiong
 * @date 2017-02-15 16:58
 */
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}
