package com.mrdios.competencymatrix.algorithm.fundamentals.AnalysisOfAlgorithm;

/**
 * union-find算法API
 *
 * @author huxiong
 * @date 2017-04-05 11:17
 */
public class UnionFind {

    private int[] id;  // 分量id（以触点为索引）
    private int[] sz;  // (由触点索引的)各个根节点所对应的分量的大小
    private int count; // 联通分量数量

    /**
     * 以整数标识（0到N-1）初始化N个触点
     *
     * @param N
     */
    public UnionFind(int N) {
        // 初始化分量id的值
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    /**
     * 返回联通分量的数量
     *
     * @return
     */
    public int count() {
        return count;
    }

    /**
     * 如果p和q存在于同一个分量重则返回true
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * p所在的分量的标识符（0到N-1）
     *
     * @param p
     * @return
     */
    private int find(int p) {
        // 跟踪连接找到根节点
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * 在p和q之间添加一条连接
     * 加权quick-union算法
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        // 将小树的根节点连接到大树的根节点
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] = sz[j];
        }
        count--;
    }

}
