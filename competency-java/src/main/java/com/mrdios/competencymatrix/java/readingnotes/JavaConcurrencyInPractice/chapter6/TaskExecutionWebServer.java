package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 基于线程池的Web服务器
 *
 * @author huxiong
 * @date 2016/06/13 15:22
 */
public class TaskExecutionWebServer {
    private static final int NTHREADS = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void handledRequest(Socket connection){
        System.out.println("do something...");
    }

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8099);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    handledRequest(connection);
                }
            };
            exec.execute(task);
        }
    }
}
