package com.mrdios.competencymatrix.designpattern.patterns.behavioral.iterator;

/**
 * @author huxiong
 * @date 2017-02-17 16:03
 */
public class App {
    public static void main(String[] args) {
        NameRepository<String> nameRepository = new NameRepository<>(5);
        for (int i = 0; i < 5; i++) {
            nameRepository.add("string " + (i + 1));
        }
        for (Iterator<String> iter = nameRepository.getIterator(); iter.hasNext(); ) {
            String name = iter.next();
            System.out.println("Name : " + name);
        }
    }
}
