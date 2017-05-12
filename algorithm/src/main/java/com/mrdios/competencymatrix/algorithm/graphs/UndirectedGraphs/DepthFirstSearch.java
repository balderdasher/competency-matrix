package com.mrdios.competencymatrix.algorithm.graphs.UndirectedGraphs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 深度优先搜索是决定在给定的无向图中有多少个顶点和起点s相连的一种数据结构
 *
 * @author huxiong
 * @date 2017-04-28 15:19
 */
public class DepthFirstSearch {

    private boolean[] marked;   // marked[v]表示是否存在s-v路径
    private int count;          // 和起点s相邻的顶点

    /**
     * 计算在图 {@code g} 中和起点相连的顶点
     *
     * @param g 图
     * @param s 起点
     */
    public DepthFirstSearch(Graph g, int s) {
        marked = new boolean[g.V()];
        validateVertex(s);
        dfs(g, s);
    }

    // 从顶点v深度优先搜索
    private void dfs(Graph g, int v) {
        count++;
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    /**
     * 在起点 {@code s} 和顶点 {@code v} 之间是否存在一条路径
     *
     * @param v 顶点 v
     * @return 路径存在返回 {@code true}, 否则返回 {@code false}
     */
    public boolean marked(int v) {
        validateVertex(v);
        return marked[v];
    }

    /**
     * 返回和起点s连通的所有顶点数
     *
     * @return 和起点s连通的所有顶点数
     */
    public int count() {
        return count;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    /**
     * Unit tests the {@code DepthFirstSearch} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);
        DepthFirstSearch search = new DepthFirstSearch(G, s);
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v))
                StdOut.print(v + " ");
        }

        StdOut.println();
        if (search.count() != G.V()) StdOut.println("NOT connected");
        else StdOut.println("connected");
    }
}
