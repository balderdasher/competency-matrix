package com.mrdios.competencymatrix.java8.feature.timedate;

import junit.framework.TestCase;
import org.junit.Assert;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author mrdios
 * @date 2017-08-19
 */
public class LocalTimeApiTest extends TestCase {

    public void testLocalTime() throws Exception {
        // 获取当前时间
        LocalTime now = LocalTime.now();
        System.out.println("现在时间：" + now);
        // 解析字符串时间
        LocalTime time = LocalTime.parse("18:30");
        System.out.println("解析时间：" + time);
        // 静态方法of创建一个时间
        LocalTime newsTime = LocalTime.of(19, 0);
        System.out.println("新闻联播" + newsTime + "开整:)");
        // 某个时间推迟几个小时候的时间
        LocalTime nextHour = now.plus(1, ChronoUnit.HOURS);
        System.out.println("1小时之后的时间是：" + nextHour);
        // 获取小时、分钟
        int hour = now.getHour();
        int minute = now.getMinute();
        System.out.println("现在时间是：" + hour + "点" + minute + "分");
        // 判断时间先后
        Assert.assertTrue(now.isAfter(now.minusHours(1)));
        Assert.assertTrue(now.isBefore(nextHour));
        // 获取每天的开始和结束时间
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.MAX);
    }
}