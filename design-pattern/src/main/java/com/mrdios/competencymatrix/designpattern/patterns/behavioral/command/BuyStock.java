package com.mrdios.competencymatrix.designpattern.patterns.behavioral.command;

/**
 * @author huxiong
 * @date 2017-02-15 16:56
 */
public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
