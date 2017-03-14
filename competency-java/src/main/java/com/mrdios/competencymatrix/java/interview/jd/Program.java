package com.mrdios.competencymatrix.java.interview.jd;

/**
 * @author huxiong
 * @date 2017-03-14 14:49
 */
public class Program {

    /**
     * 字符串转为数字
     *
     * @param str
     * @return
     */
    public static int str2Number(String str) {
        int len = str.length();
        boolean negative = false;
        int i = 0;
        int result = 0;
        if (len <= 0) {
            throw new NumberFormatException("For input string: \"" + str + "\"");
        }
        char firstChar = str.charAt(0);
        if (firstChar == '-') {
            i++;
            negative = true;
        } else if (firstChar == '+') {
            i++;
        }
        while (i < len) {
            int tmp = str.charAt(i) - '0';
            if (tmp >= 0 && tmp <= 9) {
                result = result * 10 + tmp;
            } else {
                throw new NumberFormatException("For input string: \"" + str + "\"");
            }
            i++;
        }
        if (negative) {
            result = 0 - result;
        }
        return result;
    }

    public static int str2Number2(String str) {
        int len = str.length();
        boolean negative = false;
        int result = 0;
        int i = 0;
        if (len <= 0) {
            throw new NumberFormatException("For input strings: \"" + str + "\"");
        }
        char firstChar = str.charAt(0);
        if (firstChar == '-') {
            negative = true;
            i++;
        } else if (firstChar == '+') {
            i++;
        }
        while (i < len) {
            int tmp = str.charAt(i) - '0';
            if (tmp >= 0 && tmp <= 9) {
                result += tmp * Math.pow(10, len - 1 - i);
            } else {
                throw new NumberFormatException("For input strings: \"" + str + "\"");
            }
            i++;
        }
        if (negative) {
            result = 0 - result;
        }
        return result;
    }
}
