package com.mrdios.competencymatrix.java8.feature.timedate;


import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 * @author mrdios
 * @date 2017-08-19
 */
@Tag("DateTimeApi")
public class LocalDateApiTest {

    @Test
    public void testLocalDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate:" + localDate);
        System.out.println(LocalDate.of(2017, 8, 15));
        System.out.println(LocalDate.parse("2017-08-15"));
    }

    @Test
    public void testLocalDateOpt() {
        LocalDate now = LocalDate.now();
        // 获取明天
        LocalDate tomorrow = now.plusDays(1);
        System.out.println("明天是：" + tomorrow);
        // 从今天减去一个月
        LocalDate preMonth = now.minus(1, ChronoUnit.MONTHS);
        System.out.println("上个月的今天是：" + preMonth);
        // 获取星期几
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println("今天是星期" + dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.CHINA));
        // 判断今年是不是闰年
        boolean isLeapYear = now.isLeapYear();
        System.out.println("今年是" + (isLeapYear ? "闰年" : "平年"));
        // 判断日期先后
        Assert.assertTrue(now.isAfter(now.minusDays(1)));
        Assert.assertTrue(now.isBefore(tomorrow));
        // 获取当月第一天
        LocalDate firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("当月第一天是：" + firstDayOfMonth);
        // 判断今天是不是自己生日
        MonthDay birthday = MonthDay.of(8, 15);
        MonthDay today = MonthDay.from(now);
        System.out.println("今天是我的生日：" + (today.equals(birthday) ? "Yes" : "No"));
    }
}