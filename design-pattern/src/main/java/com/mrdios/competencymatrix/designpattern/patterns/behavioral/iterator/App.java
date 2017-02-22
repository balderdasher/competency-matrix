package com.mrdios.competencymatrix.designpattern.patterns.behavioral.iterator;

/**
 * @author huxiong
 * @date 2017-02-17 16:03
 */
public class App {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();
        for (Iterator iter = nameRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}
