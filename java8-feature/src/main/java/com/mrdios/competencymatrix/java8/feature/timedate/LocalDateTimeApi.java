package com.mrdios.competencymatrix.java8.feature.timedate;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * LocalDateTime使用
 *
 * @author mrdios
 * @date 2017-08-19
 */
public class LocalDateTimeApi {
    public static void main(String[] args) {
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
                now.getMonth() + "月" +
                now.getDayOfMonth() + "日" +
                now.getHour() + "点" +
                now.getMinute() + "分" +
                now.getSecond() + "秒"
        );
    }
}
