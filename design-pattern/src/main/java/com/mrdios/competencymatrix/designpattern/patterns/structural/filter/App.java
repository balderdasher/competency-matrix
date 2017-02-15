package com.mrdios.competencymatrix.designpattern.patterns.structural.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器模式（Filter Pattern）或标准模式（Criteria Pattern）是一种设计模式，这种模式允许开发人员使用不同的标* 准来过滤一组对象，通过逻辑运算以解耦的方式把它们连接起来。这种类型的设计模式属于结构型模式，它结合多个标准来获得* 单一标准。
 *
 * @author huxiong
 * @date 2017-01-24 14:50
 */
public class App {
    private static final String MALE = "Male";
    private static final String FEMALE = "Female";
    private static final String SINGLE = "Single";
    private static final String MARRIED = "Married";

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Robert", MALE, SINGLE));
        persons.add(new Person("John", MALE, MARRIED));
        persons.add(new Person("Laura", FEMALE, MARRIED));
        persons.add(new Person("Diana", FEMALE, SINGLE));
        persons.add(new Person("Mike", MALE, SINGLE));
        persons.add(new Person("Bobby", MALE, SINGLE));

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();
        Criteria singleMale = new AndCriteria(single, male);
        Criteria singOrFemale = new OrCriteria(single, female);

        System.out.println("Males:");
        printPersons(male.meetCriteria(persons));

        System.out.println("Females:");
        printPersons(female.meetCriteria(persons));

        System.out.println("Singles:");
        printPersons(single.meetCriteria(persons));

        System.out.println("Single Males:");
        printPersons(singleMale.meetCriteria(persons));

        System.out.println("Single Or Females:");
        printPersons(singOrFemale.meetCriteria(persons));

    }

    public static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
