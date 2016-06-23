package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 使用FutureTask来提前加载稍后需要的数据
 *
 * @author huxiong
 * @date 2016/06/13 11:47
 */
public class Preloader<E> {
    private final FutureTask<E> future;
    private final Thread thread;

    public Preloader(FutureTask<E> future){
        this.future = future;
        this.thread = new Thread(future);
    }

    public void start() {
        thread.start();
    }

    public Object get() {
        try {
            return future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("oops");
        }
        return null;
    }

    public static void main(String[] args) {
        Preloader<String> preloader = new Preloader(new FutureTask<String>(new Callable() {
            @Override
            public String call() throws Exception {
                return "result";
            }
        }));
        //执行获取数据的任务
        preloader.start();
        //稍后用到任务的结果，此时若已经得到结果则直接使用，若没有则等待任务完成后返回结果
        Object result = preloader.get();
        System.out.println(result);
    }

}
