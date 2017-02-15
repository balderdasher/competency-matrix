package com.mrdios.competencymatrix.designpattern.patterns.behavioral.chanofresponsibility;

/**
 * @author huxiong
 * @date 2017-02-15 15:24
 */
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    // 责任链中的下一个元素
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (!isLegalLevel(level)) {
            throw new IllegalArgumentException("The log level is illegal." + level);
        }
        // 目标level以下的记录器都可处理请求的情况
        /*if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }*/
        // 每种记录器只处理特定level的情况
        if (this.level == level) {
            write(message);
        } else {
            if (nextLogger != null) {
                nextLogger.logMessage(level, message);
            }
        }
    }

    protected boolean isLegalLevel(int level) {
        return level == INFO
                || level == DEBUG
                || level == ERROR;
    }

    protected abstract void write(String message);
}
