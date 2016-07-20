package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter18;

import java.io.IOException;
import java.io.StringReader;

/**
 * 从内存输入
 * Created by mrdios on 2016/7/20.
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("C:\\think\\test.txt"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);//in.read()以int方式返回下一下一字节，所以要转换为char
        }
    }
}
