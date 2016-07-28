package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter21;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 需要从任务返回一个值时使用Callable
 * @author mrdios
 * @date 2016-07-28 14:15
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs:results){
            try {
                System.out.println(fs.get());
                //java7以上特性，可以对一个或多个异常做相同的处理
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
        }
    }
}
