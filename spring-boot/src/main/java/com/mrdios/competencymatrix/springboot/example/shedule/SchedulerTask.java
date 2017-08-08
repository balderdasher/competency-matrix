package com.mrdios.competencymatrix.springboot.example.shedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务类--cron表达式
 *
 * @author MrDios
 * @date 2017-08-08
 */
@Component
public class SchedulerTask {
    private int count = 0;

    @Scheduled(cron = "*/6 * * * * ?")
    public void process() {
        System.out.println("this is scheduler task running " + (count++));
    }
}
