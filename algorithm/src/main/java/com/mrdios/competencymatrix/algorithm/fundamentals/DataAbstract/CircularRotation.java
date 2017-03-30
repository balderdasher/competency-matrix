package com.mrdios.competencymatrix.algorithm.fundamentals.DataAbstract;

/**
 * 回环变位：如果字符串s中的字符循环移动任意位置之后能够得到另一个字符串t
 * 那么s就被称为t的回环变位，如ACTGACG就是TGACGAC的一个回环变位，反之亦然
 *
 * @author huxiong
 * @date 2017-03-30 16:00
 */
public class CircularRotation {

    /**
     * 判断两个字符串是否互为回环变位
     * AB和BA，AB+AB=ABAB包含BA；BA+BA=BABA包含AB--互为回环变位
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isCircularRotation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return (s + s).indexOf(t) > 0 && (t + t).indexOf(s) > 0;
    }

}
