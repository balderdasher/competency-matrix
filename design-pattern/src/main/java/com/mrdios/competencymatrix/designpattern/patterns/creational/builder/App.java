package com.mrdios.competencymatrix.designpattern.patterns.creational.builder;

/**
 * 建造者模式
 *
 * @author huxiong
 * @date 2017-01-22 15:39
 */
public class App {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vagMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vagMeal.showItems();
        System.out.println("Total Cost: " + vagMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());

        //自定义双人荤素搭配套餐
        Meal doublePersonMeal = new Meal();
        doublePersonMeal.addItem(new ChickenBurger());
        doublePersonMeal.addItem(new VegBurger());
        doublePersonMeal.addItem(new Coke());
        doublePersonMeal.addItem(new Pepsi());

        System.out.println("\nDouble-person Meal");
        doublePersonMeal.showItems();
        System.out.println("Total Cost: " + doublePersonMeal.getCost());
    }

}
