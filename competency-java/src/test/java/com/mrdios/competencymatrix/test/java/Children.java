package com.mrdios.competencymatrix.test.java;

import java.util.LinkedList;
import java.util.List;

/**
 * @author mrdios
 * @date 2016-08-09 17:09
 */
public class Children {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= 9; i++) list.add(i); //添加100个小盆友的编号对应每一个人
        int j = 0; //记录报数次数
        while (list.size() != 1) { //list中剩下一个人得时候跳出循环
            int k = list.remove(0); //删除第一个元素即报数的小朋友
            j++; //每次报数后 j+1
            if (j % 3 != 0) list.add(k); //如果j不是3得倍数 把刚报完数字的小朋友放在队伍的最后面
        }
        System.out.println(j);
        System.out.println(list); //剩下的最后一个就是我们需要的编号
    }
}
