package com.mrdios.competencymatrix.springboot.example.shedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务--间隔执行
 *
 * @author MrDios
 * @date 2017-08-08
 */
@Component
public class SchedulerTask2 {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        System.out.println("Time now is : " + dateFormat.format(new Date()));
    }
}
