package com.mrdios.competencymatrix.concurrency.util;

import java.util.concurrent.TimeUnit;

/**
 * @author MrDios
 * @date 2017-06-13
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
