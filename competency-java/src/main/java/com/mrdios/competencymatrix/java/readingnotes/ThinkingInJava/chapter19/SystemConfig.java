package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter19;

import java.text.DateFormat;
import java.util.Date;

/**
 * 常量相关的方法
 * Created by mrdios on 2016/7/22.
 */
public enum SystemConfig {
    DATE_TIME {
        @Override
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        @Override
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (SystemConfig config : values()) {
            System.out.println(config.getInfo());
        }

    }
}
