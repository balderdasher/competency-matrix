package com.mrdios.competencymatrix.java.api.java.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author CodePorter
 * @date 2018-01-05
 */
public class LinkedHashMapTest {
    private static final Logger logger = LogManager.getLogger();
    private Map<String, Integer> map;

    @Before
    public void setUp() {
        map = new LinkedHashMap<>();
    }

    @Test
    public void testAccessOrder() {
        map = new LinkedHashMap<>(16, 0.75f, true);
        fillMap(10);
        logger.info("LinkedMap初始化后的顺序：{}", map);
        Integer x = map.get("J");
        logger.info("LinkedMap访问过元素后的顺序：{}", map);
    }

    private void fillMap(int size) {
        for (int i = 0; i < size; i++) {
            map.put(String.valueOf((char) (i + 65)), i + 1);
        }
    }

    @Test
    public void testInner() {
        Inner in = new Inner();
        in.a = "fuck";
        in.doSth();
    }

    private class Inner {
        private String a;

        private void doSth() {
            System.out.println("Inner::doSth()");
        }
    }
}
