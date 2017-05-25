package com.mrdios.competencymatrix.algorithm.strings.SubstringSearch;

import edu.princeton.cs.algs4.StdOut;

/**
 * 暴力子字符串查找算法
 *
 * @author MrDios
 * @date 2017-05-24
 */
public class Brute {
    public static int search1(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == M) return i;   // 找到匹配
        }
        return N;                   // 未找到匹配
    }

    /**
     * 另一种实现（显式回退）
     *
     * @param pat 模式
     * @param txt 字符串
     * @return 所在位置
     */
    public static int search2(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) {
            return i - M;    //找到匹配
        } else {
            return N;        //未找到匹配
        }
    }

    public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];

        int offset1a = search1(pat, txt);
        int offset2a = search2(pat, txt);

        // print results
        StdOut.println("text:    " + txt);

        // from brute force search method 1a
        StdOut.print("pattern: ");
        for (int i = 0; i < offset1a; i++)
            StdOut.print(" ");
        StdOut.println(pat);

        // from brute force search method 2a
        StdOut.print("pattern: ");
        for (int i = 0; i < offset2a; i++)
            StdOut.print(" ");
        StdOut.println(pat);
    }
}
