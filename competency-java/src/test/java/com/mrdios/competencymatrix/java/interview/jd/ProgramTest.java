package com.mrdios.competencymatrix.java.interview.jd;

import base.BaseTest;
import org.junit.Test;

/**
 * @author huxiong
 * @date 2017-03-14 15:16
 */
public class ProgramTest extends BaseTest {
    @Test
    public void str2Number() throws Exception {
        assertTrue(Program.str2Number("1234") == 1234);
    }

    @Test
    public void str2Number2() throws Exception {
        assertTrue(Program.str2Number2("1234") == 1234);
    }

}