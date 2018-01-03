package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter18;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道流
 *
 * @author CodePorter
 * @date 2017-12-28
 */
public class PipeExample {
    public static void main(String[] args) throws Exception {
        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream input = new PipedInputStream(output);

        Thread writer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    output.write("Hello pipe!".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread reader = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int data;
                    while ((data = input.read()) != -1) {
                        System.out.print((char) data);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        writer.start();
        reader.start();
    }
}
