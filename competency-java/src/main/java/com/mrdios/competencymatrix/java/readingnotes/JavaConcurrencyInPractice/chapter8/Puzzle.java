package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter8;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 搬箱子谜题的抽象类
 * P:位置类
 * M:移动类
 *
 * @author huxiong
 * @date 2016/06/16 12:37
 */
public interface Puzzle<P, M> {
    /**
     * 初始化位置
     *
     * @return
     */
    P initialPosition();

    /**
     * 是否得分
     *
     * @param position
     * @return
     */
    boolean isGoal(P position);

    /**
     * 合法移动
     *
     * @param position
     * @return
     */
    Set<M> legalMoves(P position);

    /**
     * 每次移动的结果位置
     *
     * @param position
     * @param move
     * @return
     */
    P move(P position, M move);

    /**
     * 用于谜题解决框架的链表节点
     * 通过一系列移动到达的一个位置，沿着Node链接逐步回溯，就可以重新构建出到达当前位置的移动序列
     *
     * @param <P>
     * @param <M>
     */
    static class Node<P, M> {
        final P pos;//位置
        final M move;//到达该位置的移动
        final Node<P, M> prev;//前一个Node

        public Node(P pos, M move, Node<P, M> prev) {
            this.pos = pos;
            this.move = move;
            this.prev = prev;
        }

        /**
         * 到达该位置的有效移动路径
         *
         * @return
         */
        List<M> asMoveList() {
            List<M> solution = new LinkedList<M>();
            for (Node<P, M> n = this; n.move != null; n = n.prev) {
                solution.add(0, n.move);
            }
            return solution;
        }
    }
}
