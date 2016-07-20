package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter18;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * 格式化的内存输入
 * Created by mrdios on 2016/7/20.
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("C:\\think\\test.txt").getBytes()));

            while (true){
                System.out.print((char)in.readByte());
            }
        } catch (IOException e) {
            System.err.println("End of stream");
        }
    }
}
