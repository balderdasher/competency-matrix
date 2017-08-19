package com.mrdios.competencymatrix.java8.feature.timedate;

import junit.framework.TestCase;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author mrdios
 * @date 2017-08-19
 */
public class LocalDateTimeApiTest extends TestCase {

    /**
     * 基本使用
     *
     * @throws Exception
     */
    public void testLocalDateTimeApi() throws Exception {
        // 获取当前时间和日期
        LocalDateTime now = LocalDateTime.now();
        System.out.println("现在时间是：" + now);
        // 日期时间解析
        System.out.println(LocalDateTime.of(2017, Month.AUGUST, 20, 22, 19, 30));
        // 计算时间和日期
        System.out.println("明天的这个时候是：" + now.plusDays(1));
        System.out.println("两小时前的时间是：" + now.minusHours(2));
        // 获取年月日时分秒等
        System.out.println("当前时间是：" +
                now.getYear() + "年" +
                now.getMonth().getValue() + "月" +
                now.getDayOfMonth() + "日" +
                now.getHour() + "点" +
                now.getMinute() + "分" +
                now.getSecond() + "秒"
        );
    }

    /**
     * 日期格式化
     */
    public void testLocalDateTimeFormat() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("原始日期时间格式：" + now);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("自定义日期格式：" + now.format(dateTimeFormatter));
        LocalDateTime localDateTime = LocalDateTime.parse("2017-08-20 22:15:30", dateTimeFormatter);
        System.out.println("按自定义格式转换字符串为日期时间：" + localDateTime);
    }

    /**
     * 日期周期
     *
     * @throws Exception
     */
    public void testPeriod() throws Exception {
        // 加上固定天数
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime afterFiveDays = now.plus(Period.ofDays(5));
        System.out.println("五天之后的这个时候是：" + afterFiveDays);
        // 比较日期差别
        System.out.println("两个时间相差：" + ChronoUnit.DAYS.between(now, afterFiveDays) + "天");
    }

    /**
     * 遗留代码转换
     */
    public void testConvertToHistoryDate() {
        // Date和Instant互相转换
        Date date = Date.from(Instant.now());
        Instant instant = date.toInstant();
        // Date转换为LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.from((TemporalAccessor) date);
        System.out.println(localDateTime);
        // LocalDateTime转Date
        Date date1 =
                Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        // LocalDate转Date
        Date date2 =
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

}