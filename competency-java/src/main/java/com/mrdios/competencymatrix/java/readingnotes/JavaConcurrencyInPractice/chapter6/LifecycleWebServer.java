package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 支持关闭操作的Web服务器
 *
 * @author huxiong
 * @date 2016/06/13 15:37
 */
public class LifecycleWebServer {
    private final ExecutorService exec = Executors.newCachedThreadPool();

    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(8099);
        while (!exec.isShutdown()) {
            final Socket conn = socket.accept();
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("do");
                }
            });
        }
    }

    public void stop() {
        exec.shutdown();
    }

}
