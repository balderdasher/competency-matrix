package com.mrdios.competencymatrix.java.interview.jd;

import java.util.LinkedList;
import java.util.List;

/**
 * 京东笔试编程题-约瑟夫环问题：
 * 1,2,3,4,5...n个人围成一个圈，然后进行1,2,3报数
 * 某个人报到3时站出来，后面的人继续报数，报到3的就站出来
 * 直到最后一人
 *
 * @author mrdios
 * @date 2016-08-09 18:15
 */
public class CountGame {
    List<Integer> listNum = new LinkedList<>();

    /**
     * 从队列下标思考
     *
     * @param total 参与游戏人数
     * @param from  从编号几开始报数
     * @param step  报到几退出
     */
    public void count1(int total, int from, int step) {
        for (int i = 1; i <= total; i++) {
            listNum.add(i);
        }
        int i = 0;//报数次数
        int startIndex = from - 1;//当前报数人在队列的下标
        int exitIndex;//当前循环退出人的下标
        //只要不是剩一个人游戏就继续
        while (listNum.size() > 1) {
            i++;
            int delIndex = startIndex + step - 1;
            if (delIndex <= listNum.size() - 1) {
                exitIndex = delIndex;
            } else {
                exitIndex = delIndex % listNum.size();
            }
            int nextStart = exitIndex + 1;
            if (nextStart <= listNum.size() - 1) {
                startIndex = nextStart - 1;
            } else {
                startIndex = nextStart % listNum.size();
            }
            listNum.remove(exitIndex);
        }
        System.out.println(listNum);
        System.out.println("count3循环了" + i + "次");
    }

    /**
     * 从编号思考
     *
     * @param total 游戏人数
     * @param from  从编号几开始报数
     * @param step  报到几退出
     */
    public void count2(int total, int from, int step) {
        for (int i = 1; i <= total; i++) {
            listNum.add(i);
        }
        // 每次开始报数的编号
        int start = from;
        // 每次退出人的编号
        int exit;
        // 循环次数
        int count = 0;
        while (true) {
            count++;
            // 只要开始报数的人没到队尾，退出的人在往下数到队尾的人中，否则进行到队头往下数
            int exitIndex = listNum.indexOf(start) + step - 1;
            if (exitIndex < listNum.size()) {
                exit = listNum.get(exitIndex);
            } else {
                exit = listNum.get(exitIndex % listNum.size());
            }
            // 计算下次开始的编号并退出
            int startIndex = listNum.indexOf(exit) + 1;
            if (startIndex < listNum.size()) {
                start = listNum.get(listNum.indexOf(exit) + 1);
            } else {
                start = listNum.get((startIndex) % listNum.size());
            }
            listNum.remove(listNum.indexOf(exit));
            // 剩下最后一人退出游戏，否则根据这次退出的人编号来计算下次开始报数的编号
            if (listNum.size() == 1) {
                break;
            }
        }
        System.out.println(listNum);
        System.out.println("count4循环了" + count + "次");
    }

    public static void main(String[] args) {
        new CountGame().count1(9, 1, 3);
        new CountGame().count2(9, 1, 3);
    }
}
