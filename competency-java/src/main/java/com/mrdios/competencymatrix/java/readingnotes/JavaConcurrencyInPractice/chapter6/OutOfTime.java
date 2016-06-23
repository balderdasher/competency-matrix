package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter6;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * 错误的Timer行为
 * @author huxiong
 * @date 2016/06/13 15:57
 */
public class OutOfTime {
    public static void main(String[] args) throws Exception{
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(),1);
        TimeUnit.SECONDS.sleep(1);
        timer.schedule(new ThrowTask(),5);
        TimeUnit.SECONDS.sleep(5);
    }

    static class ThrowTask extends TimerTask{
        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
}
