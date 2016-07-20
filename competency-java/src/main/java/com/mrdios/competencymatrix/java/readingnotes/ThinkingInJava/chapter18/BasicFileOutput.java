package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter18;

import java.io.*;

/**
 * 基本的文件输出
 * Created by mrdios on 2016/7/20.
 */
public class BasicFileOutput {
    static String fileIn = "C:\\think\\test.txt";
    static String fileOut = "C:\\think\\BasicFileOutput.out";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(fileIn)));
        PrintWriter out = new PrintWriter(new FileWriter(fileOut));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null){
            // 写入
            out.println(lineCount++ + "：" + s);
        }
        out.close();
        // 显示存储的文件
        System.out.println(BufferedInputFile.read(fileOut));
    }
}
