package com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues;

import com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.queue.Queue;
import com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.stack.Stack;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author huxiong
 * @date 2017-04-01 9:49
 */
public class PracticesTest {

    /**
     * 判断字符串中包含的括号是否配对
     *
     * @throws Exception
     */
    @Test
    public void isParantheses() throws Exception {
        String s = "[()]{}{[()[]()]()}";
        String s1 = "[(])";
        Assert.assertTrue(Practices.isParantheses(s));
        Assert.assertFalse(Practices.isParantheses(s1));
    }

    /**
     * 字符串为push “-”为pop，求s最后输出什么
     */
    @Test
    public void test1() {
        String s = "it was - the best - of times - - - it was - the - -";
        String[] strs = s.split(" ");
        Stack<String> sdk = new Stack<>();
        for (int i = 0; i < strs.length; i++) {
            String temp = strs[i];
            if (!"-".equals(temp)) {
                sdk.push(temp);
            } else {
                sdk.pop();
            }
        }
        for (String string : sdk) {
            System.out.println(string);
        }
    }

    /**
     * 输出字符串的倒数第k个字符串
     */
    @Test
    public void test2() {
        String s = "HelloWorld";
        Queue<String> q = new Queue<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            q.enqueue(String.valueOf(s.charAt(i)));
        }
        int k = 3;
        for (int i = 1; i <= k; i++) {
            if (i == k) {
                System.out.println(q.dequeue());
            } else {
                q.dequeue();
            }
        }
    }

    /**
     * 删除队列中指定位置的元素
     */
    @Test
    public void testQueueDel() {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 9; i++) {
            queue.enqueue((i + 1) * 10);
        }
        queue.delete(1);
        for (Integer i : queue) {
            System.out.print(i + " ");
        }
    }

    /**
     * 约瑟夫环测试
     */
    @Test
    public void testJosephus() {
        Queue<Integer> died = Practices.josephusCircle(7, 4);
        for (Integer p : died) {
            System.out.print(p + " ");
        }
    }


}