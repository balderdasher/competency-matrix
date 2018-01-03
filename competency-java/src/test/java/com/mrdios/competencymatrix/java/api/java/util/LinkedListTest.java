package com.mrdios.competencymatrix.java.api.java.util;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author CodePorter
 * @date 2017-12-29
 */
public class LinkedListTest {
    private LinkedList<Integer> list = new LinkedList<>();

    @Before
    public void setUp() {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void test1() {
    }

    @Test
    public void testIteDel() {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
//            Integer item = iterator.next();
            iterator.remove();
        }
        System.out.println(list);
    }

    @Test
    public void testForEachDel() {
        for (Integer i :
                list) {
            list.remove(i);
        }
        System.out.println(list);
    }

    @Test
    public void testForEachDelete() {
        System.out.println(list);
    }
}
