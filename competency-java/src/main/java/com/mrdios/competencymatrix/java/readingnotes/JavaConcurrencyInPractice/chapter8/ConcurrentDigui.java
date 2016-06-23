package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * 将串行递归转换为并行递归
 *
 * @author huxiong
 * @date 2016/06/16 11:07
 */
public class ConcurrentDigui<T> {
    /**
     * 串行递归
     *
     * @param nodes
     * @param results
     * @param <T>
     */
    public <T> void sequentialRecursive(List<Object> nodes, Collection<Object> results) {
        for (Object n : nodes) {
            results.add(n);
            // 第一个参数实际为n中的某个返回List<Object>类型数据的方法
            sequentialRecursive(new ArrayList<Object>(), results);
        }
    }

    /**
     * 并行递归
     *
     * @param exec
     * @param nodes
     * @param results
     */
    public void parallelRecursive(final Executor exec, List<Object> nodes, final Collection<Object> results) {
        for (final Object n : nodes) {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    //此处n实际为一个计算过程
                    results.add(n);
                }
            });
            parallelRecursive(exec, new ArrayList<Object>(), results);
        }
    }

    /**
     * 等待通过并行方式计算的结果
     * 注：上面的并行递归中遍历仍然是串行的，只有add(n)中的n方法是并行执行的，并且每个节点的计算任务都已放入Executor
     * 的工作队列
     *
     * @param nodes
     * @return
     * @throws InterruptedException
     */
    public Collection<Object> getParallelResults(List<Object> nodes) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Queue<Object> resultQueue = new ConcurrentLinkedDeque<>();
        parallelRecursive(exec, nodes, resultQueue);
        exec.shutdown();
        exec.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        return resultQueue;
    }
}
