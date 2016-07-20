package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter18;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * 用zip进行多文件保存
 * Created by mrdios on 2016/7/20.
 */
public class Zipcompress {
    static String[] files = new String[]{"C:\\think\\BasicFileOutput.out","C:\\think\\test.txt"};
    public static void main(String[] args) throws IOException {
        FileOutputStream f = new FileOutputStream("test.zip");
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        zos.setComment("A test of java Zipping");
        for (String file: files){
            System.out.println("Writing file " + file);
            BufferedReader in = new BufferedReader(new FileReader(file));
            zos.putNextEntry(new ZipEntry(file));
            int c;
            while ((c = in.read()) != -1){
                out.write(c);
            }
            in.close();
            out.flush();
        }
        out.close();
        // 关闭文件流之后才能校验
        System.out.println("Checksum: " + csum.getChecksum().getValue());
        // 解压文件
        System.out.println("Reading file...");
        FileInputStream fi = new FileInputStream("test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fi,new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);
        ZipEntry ze;
        while ((ze = in2.getNextEntry()) != null){
            System.out.println("Reading file " + ze);
            int x;
            while ((x = bis.read()) !=-1){
                System.out.print((char)x);
            }
        }
        System.out.println("\nShow entries...");
        if (files.length == 1){
            System.out.println("Checksum: " + csumi.getChecksum().getValue());
        }
        bis.close();
        ZipFile zf = new ZipFile("test.zip");
        Enumeration e = zf.entries();
        while (e.hasMoreElements()){
            ZipEntry ze2 = (ZipEntry) e.nextElement();
            System.out.println("File: " + ze2);
        }
    }
}
