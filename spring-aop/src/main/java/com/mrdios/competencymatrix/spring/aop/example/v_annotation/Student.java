package com.mrdios.competencymatrix.spring.aop.example.v_annotation;

/**
 * @author mrdios
 * @date 2017-08-23
 */
public class Student {
    private String name;
    private Integer age;

    public String getName() {
        System.out.println("[Student::getName()]：" + name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        System.out.println("[Student::getAge()]：" + age);
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void getAnException() {
        System.out.println("[Student::throwAnException]：Exception happened.");
        throw new IllegalArgumentException();
    }

    public void save(Student student) {
        System.out.println("[Student::save()]：" + student);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
