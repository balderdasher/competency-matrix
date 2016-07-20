package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter18;

import java.io.*;

/**
 * 存储和恢复数据
 * Created by mrdios on 2016/7/20.
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        // store
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\think\\Data.txt")));
        out.writeDouble(3.1415926);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();
        // recover
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("C:\\think\\Data.txt")));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}
