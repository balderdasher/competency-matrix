package com.mrdios.competencymatrix.java.api.java.lang;

import org.junit.Test;

import java.lang.Object;
import java.lang.System;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

/**
 * @author CodePorter
 * @date 2017-12-15
 */
public class System1Test {

    @Test
    public void getSysEnv() throws Exception {
        Map<String, String> envs = System1.getSysEnv();
        for (String key : envs.keySet()) {
            System.out.println(key + ": " + envs.get(key));
        }
    }

    @Test
    public void getPorps() {
        Properties props = System.getProperties();
        for (Object key : props.keySet()) {
            System.out.println(key + ": " + props.get(key));
        }
    }

    @Test
    public void testArrayCopy() {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {6, 5, 4, 3, 2, 1};
        System.arraycopy(a, 1, b, 2, 3);
        System.out.println(Arrays.toString(b));
    }
}