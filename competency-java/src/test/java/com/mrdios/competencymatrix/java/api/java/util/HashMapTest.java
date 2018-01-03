package com.mrdios.competencymatrix.java.api.java.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CodePorter
 * @date 2018-01-03
 */
public class HashMapTest {
    private Map<String, Integer> map = new HashMap<String, Integer>() {
        {
            put("Andy", 10);
            put("Tony", 12);
        }
    };

    @Test
    public void testMoveBit() {
        System.out.println(5 << 1);
    }

}
