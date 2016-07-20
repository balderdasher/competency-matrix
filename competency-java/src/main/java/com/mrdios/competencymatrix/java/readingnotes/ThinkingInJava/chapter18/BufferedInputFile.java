package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 缓冲输入文件
 * Created by mrdios on 2016/7/19.
 */
public class BufferedInputFile {
    public static String read(String fileName) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(new File(fileName)));
        String s;
        StringBuffer sb = new StringBuffer();
        while ((s = in.readLine()) != null){
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("C:\\think\\test.txt"));
    }
}
