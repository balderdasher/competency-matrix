package com.mrdios.competencymatrix.algorithm.graphs.UndirectedGraphs;

import edu.princeton.cs.algs4.In;

/**
 * 图的一个客户端
 *
 * @author huxiong
 * @date 2017-04-27 14:38
 */
public class GraphClient {

    // 计算图的最大 度
    public static int maxDegree(Graph g) {
        int max = 0;
        for (int v = 0; v < g.V(); v++) {
            if (g.degree(v) > max) {
                max = g.degree(v);
            }
        }
        return max;
    }

    // 平均 度
    public static int avgDegree(Graph g) {
        // 每条边都连着两个顶点
        return 2 * g.E() / g.V();
    }

    // 自环的数量
    public static int numberOfSelfLoop(Graph g) {
        int count = 0;
        for (int v = 0; v < g.V(); v++) {
            for (int w : g.adj(v)) {
                if (v == w) count++;
            }
        }
        return count / 2;   // 自环在邻接表中出现了两次
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph g = new Graph(in);
        System.out.println(g);

        System.out.println("vertex of maximum degree = " + maxDegree(g));
        System.out.println("average degree           = " + avgDegree(g));
        System.out.println("number of self loops     = " + numberOfSelfLoop(g));
    }
}
