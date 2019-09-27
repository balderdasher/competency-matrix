package com.mrdios.competencymatrix.java.api.lang.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author mrdios
 * @date 2018-01-14
 */
public class ForkJoinExample {

    public static void main(String[] args) {
        long countSum = 1000000000;
        long start = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        CountSumTask task = new CountSumTask(1, countSum);
        Future<Long> result = pool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Fork join cost time: " + (System.currentTimeMillis() - start));
        long start1 = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < countSum; i++) {
            sum += i;
        }
        System.out.println("Single thread cost time: " + (System.currentTimeMillis() - start1));

    }

    static class CountSumTask extends RecursiveTask<Long> {
        private static final int THRESHOLD = 2;
        private long start, end;

        public CountSumTask(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            long sum = 0;
            boolean computable = (end - start) <= THRESHOLD;

            // 任务足够小时计算任务
            if (computable) {
                for (long i = start; i <= end; i++) {
                    sum += i;
                }
            }
            // 任务还是很大时继续分解成小任务
            else {
                long middle = start + (end - start) / 2;
                CountSumTask leftSubTask = new CountSumTask(start, middle);
                CountSumTask rightSubTask = new CountSumTask(middle + 1, end);
                // 执行子任务
                leftSubTask.fork();
                rightSubTask.fork();
                // 任务执行完成收集结果
                long leftSubResult = leftSubTask.join();
                long rightSubResult = rightSubTask.join();
                // 合并子任务结果
                sum = leftSubResult + rightSubResult;
            }
            return sum;
        }
    }
}
