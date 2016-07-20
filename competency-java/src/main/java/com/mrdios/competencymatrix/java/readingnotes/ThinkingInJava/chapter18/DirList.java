package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.io.PipedReader;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by mrdios on 2016/7/19.
 */
public class DirList {
    public static void listView(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(filter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }

    public static FilenameFilter filter(final String regex){
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        listView(new String[]{".java"});
    }
}
