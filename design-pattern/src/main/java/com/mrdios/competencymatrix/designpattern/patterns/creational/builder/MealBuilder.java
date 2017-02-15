package com.mrdios.competencymatrix.designpattern.patterns.creational.builder;

/**
 * 套餐建造器
 *
 * @author huxiong
 * @date 2017-01-22 15:34
 */
public class MealBuilder {
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
