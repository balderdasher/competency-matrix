package com.mrdios.competencymatrix.java.api.java.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CodePorter
 * @date 2018-01-03
 */
public class HashMapTest {

    @Test
    public void testMoveBit() {
        System.out.println(5 << 1);
    }

    /**
     * HashMap是无序的(输出的顺序有可能和插入的顺序不同)
     */
    @Test
    public void testWithoutOrder() {
        HashMap<String, Object> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf((char) (i + 65)), i);
        }
        System.out.println(map.size());
        System.out.println(map);
    }

    public static void main(String[] args) {
        System.out.println((int) 'A');
    }

}
