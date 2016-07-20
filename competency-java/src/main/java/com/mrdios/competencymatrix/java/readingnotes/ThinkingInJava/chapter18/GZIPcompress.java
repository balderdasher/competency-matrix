package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter18;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 单个文件的GZIP压缩
 * Created by mrdios on 2016/7/20.
 */
public class GZIPcompress {
    static String file = "C:\\think\\test.txt";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("C:\\think\\test.gz")));
        System.out.println("Writing file...");
        int c;
        while ((c = in.read()) != -1){
            out.write(c);
        }
        in.close();
        out.close();
        System.out.println("Reading file...");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("C:\\think\\test.gz"))));
        String s;
        while ((s = in2.readLine()) != null){
            System.out.println(s);
        }
    }
}
