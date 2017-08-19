package com.mrdios.competencymatrix.java8.feature.timedate;

import org.junit.Assert;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * LocalDate使用
 *
 * @author mrdios
 * @date 2017-08-19
 */
public class LocalDateApi {

    public static void main(String[] args) {
        // 获取今天
        LocalDate now = LocalDate.now();
        System.out.println("今天是：" + now);
        // 获取明天
        LocalDate tomorrow = now.plusDays(1);
        System.out.println("明天是：" + tomorrow);
        // 从今天减去一个月
        LocalDate preMonth = now.minus(1, ChronoUnit.MONTHS);
        System.out.println("上个月的今天是：" + preMonth);
        // 获取星期几
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println("今天是星期" + dayOfWeek);
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
