package com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues;

import com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.queue.Queue;
import com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.stack.Stack;

/**
 * @author huxiong
 * @date 2017-03-31 19:23
 */
public class Practices {

    /**
     * 判断一个字符串中的括号是否配对，如[()]{}{[()[]()]()}返回true，[(])返回false
     *
     * @param s
     * @return
     */
    public static boolean isParantheses(String s) {
        Stack<Character> sdk = new Stack<>();
        Character c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                // 压入左括号
                sdk.push(c);
            } else if (c == ']' || c == ')' || c == '}') {
                if (sdk.isEmpty()) return false;
                // 弹出左括号
                Character left = sdk.pop();
                // 检查左右括号是否匹配
                if (left == '[' && c != ']') {
                    return false;
                } else if (left == '(' && c != ')') {
                    return false;
                } else if (left == '{' && c != '}') {
                    return false;
                }
            }
        }

        // 判断完成后如果配对，栈中不应有余
        return sdk.isEmpty();
    }

    /**
     * 用队列解决约瑟夫环问题：n个人围坐一圈（位置为0到n-1）从第一个人报数报到m的人将被杀死直到最后一人留下来，
     * 求出这n个人被杀死的顺序
     *
     * @param n 总人数
     * @param m 夺命数
     * @return 死亡队列 队列末尾就是可以生存的人
     */
    public static Queue<Integer> josephusCircle(int n, int m) {
        if (n <= 1 || m <= 1) {
            throw new IllegalArgumentException();
        }
        Queue<Integer> people = new Queue<>();      // 游戏队列
        Queue<Integer> diedpeople = new Queue<>();  // 死亡队列
        for (int i = 0; i < n; i++) {
            people.enqueue(i);
        }
        while (!people.isEmpty()) {
            // 从1开始报数
            for (int j = 1; j <= m; j++) {
                // 每轮报数的人出列
                Integer k = people.dequeue();
                if (j == m) {
                    // 报到m的人进入死亡队列
                    diedpeople.enqueue(k);
                } else {
                    // 本轮报数没报到m的人入列继续游戏（一个圈）
                    people.enqueue(k);
                }
            }
        }
        return diedpeople;
    }

}
