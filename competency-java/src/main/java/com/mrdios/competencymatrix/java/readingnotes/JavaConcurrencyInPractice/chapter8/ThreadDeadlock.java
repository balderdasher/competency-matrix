package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 在单线程Executor中任务发生死锁（线程饥饿死锁）
 *
 * @author huxiong
 * @date 2016/06/14 17:24
 */
public class ThreadDeadlock {
    static ExecutorService exec = Executors.newSingleThreadExecutor();

    public static class RendPageTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            Future<String> header, footer;
            header = exec.submit(new LoadFileTask("header.html"));
            footer = exec.submit(new LoadFileTask("footer.html"));
            String page = "renderBody()";
            // 将发生死锁--由于任务在等待子任务的结果
            return header.get() + page + footer.get();
        }
    }

    public static class LoadFileTask implements Callable<String> {
        private final String name;

        public LoadFileTask(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            return this.name;
        }
    }

}
