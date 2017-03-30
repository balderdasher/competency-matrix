package com.mrdios.competencymatrix.algorithm.fundamentals.DataAbstract;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huxiong
 * @date 2017-03-30 15:33
 */
public class Practices {
    /**
     * 测试短路,&&前面的表达式若为false则&&之后的表达式不会执行
     */
    @Test
    public void testShortCircuitAnd() {
        if (isFalse() && isTrue()) {
            System.out.println("false && true");
        }
    }

    private boolean isTrue() {
        System.out.println("This is true");
        return true;
    }

    private boolean isFalse() {
        System.out.println("This is false");
        return false;
    }

    /**
     * 输出：0,1,1,2,3,5,8,13...
     */
    @Test
    public void test2() {
        int f = 0, g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }

    /**
     * 整数转化为二进制输出
     */
    @Test
    public void testInt2BinaryString() {
        System.out.println(int2BinaryString(8));
    }

    private String int2BinaryString(int n) {
        String s = "";
        for (int i = n; i > 0; i /= 2) {
            s = (i % 2) + s;
        }
        return s;
    }

    /**
     * String的不可变性，改变字符串值实际是将引用指向另一个字符串
     * 输出：
     * world
     * hello
     */
    @Test
    public void testString() {
        String str1 = "hello";
        String str2 = str1;
        str1 = "world";
        System.out.println(str1);
        System.out.println(str2);
    }

    /**
     * 字符串的不可变性，针对字符串的各种操作返回的是一个新字符串而没有改变原本的值
     * 输出：
     * Hello World
     */
    @Test
    public void testString2() {
        String str = "Hello World";
        str.toUpperCase();
        str.substring(6, 11);
        System.out.println(str);
    }

    /**
     * 回环变位：如果字符串s中的字符循环移动任意位置之后能够得到另一个字符串t
     * 那么s就被称为t的回环变位，如ACTGACG就是TGACGAC的一个回环变位，反之亦然
     */
    @Test
    public void testCircularRotation() {
        Assert.assertTrue(CircularRotation.isCircularRotation("ACTGACG", "TGACGAC"));
        Assert.assertFalse(CircularRotation.isCircularRotation("ACTGACG", "TGACGAA"));
    }

}