package com.mrdios.competencymatrix.java.api.java.util;

import org.junit.Test;

import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CodePorter
 * @date 2017-12-28
 */
public class ArrayListTest {

    @Test
    public void testDefaultLen() {
        ArrayList<String> list = new ArrayList<>();
        Object[] ele = {};
        System.out.println(ele.length);
        System.out.println(list.size());
    }
}
