package com.mrdios.competencymatrix.java8.feature.function;

import junit.framework.TestCase;

/**
 * @author mrdios
 * @date 2017-08-19
 */
public class ConsumerInterfaceTest extends TestCase {
    public void testDonation() throws Exception {
        ConsumerInterface.donation(5000, money -> System.out.println("好心的麦乐迪为Blade捐赠了" + money + "元"));
    }

}