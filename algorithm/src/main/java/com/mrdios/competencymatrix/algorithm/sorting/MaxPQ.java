package com.mrdios.competencymatrix.algorithm.sorting;

import java.util.PriorityQueue;

/**
 * 基于二叉堆的优先队列
 *
 * @author huxiong
 * @date 2017-04-11 10:50
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;       // 基于堆的完全二叉树
    private int N = 0;      // 存储于pq[0..N]中，pq[0]没有使用

    /**
     * 创建一个优先队列
     */
    public MaxPQ() {
    }

    /**
     * 创建一个最大容量为max的优先队列
     *
     * @param maxN 最大容量值
     */
    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    /**
     * 用a[]中的元素创建一个优先队列
     *
     * @param a an array
     */
    public MaxPQ(Key[] a) {
    }

    /**
     * 返回队列是否为空
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 返回优先队列中的元素个数
     *
     * @return element count
     */
    public int size() {
        return N;
    }

    /**
     * 插入一个元素
     *
     * @param v an element
     */
    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    /**
     * 返回最大元素
     */
    public Key max() {
        return pq[1];
    }

    /**
     * 删除并返回最大元素
     */
    public Key delMax() {
        Key max = max();  // 从根节点得到最大元素
        exch(1, N--);   // 将其和最后一个节点交换
        pq[N + 1] = null; // 防止越界
        sink(1);        // 恢复堆的有序性
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    /**
     * 由下至上的堆有序变化（上浮）的实现
     * k节点的父节点的位置是k/2
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    /**
     * 由上至下的堆有序变化（下沉）的实现
     * k节点的子节点位于2k和2k+1
     *
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 3, 6, 4, 2, 1, 7, 9, 8, 10};
        MaxPQ<Integer> pq = new MaxPQ<>(10);
        PriorityQueue<Integer> p = new PriorityQueue<>(10);
        System.out.println(pq.isEmpty());
        for (Integer i : nums) {
            pq.insert(i);
            p.add(i);
        }
        System.out.println(pq.max());
        pq.delMax();
        System.out.println(pq.max());
    }
}
