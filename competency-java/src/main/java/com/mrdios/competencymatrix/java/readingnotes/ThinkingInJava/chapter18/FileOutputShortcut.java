package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * 文本文件输出的快捷方式
 * Created by mrdios on 2016/7/20.
 */
public class FileOutputShortcut {
    static String fileIn = "C:\\think\\test.txt";
    static String fileOut = "C:\\think\\FileOutputShortcut.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(fileIn)));
        // 快捷方式
        PrintWriter out = new PrintWriter(fileOut);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null){
            out.println(lineCount++ + ":" + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(fileOut));
    }
}
