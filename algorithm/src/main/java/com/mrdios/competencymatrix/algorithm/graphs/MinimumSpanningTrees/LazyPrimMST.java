package com.mrdios.competencymatrix.algorithm.graphs.MinimumSpanningTrees;

import com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.queue.Queue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * Prim算法-延时实现
 *
 * @author huxiong
 * @date 2017-05-17 15:38
 */
public class LazyPrimMST {
    private boolean[] marked;                   // 最小生成树的顶点
    private Queue<Edge> mst;                    // 最小生成树的边
    private MinPQ<Edge> pq;                     // 横切边（包括失效的边）
    private double weight;                      // 最小生成树的总权重

    public LazyPrimMST(EdgeWeightedGraph g) {
        pq = new MinPQ<>();
        marked = new boolean[g.V()];
        mst = new Queue<>();

        visit(g, 0);                          // 假设g是连通的
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();               // 从pq中得到权重最小的边
            int v = e.either(), w = e.other(v); // 跳过失效的边
            if (marked[v] && marked[w]) continue;
            mst.enqueue(e);                     // 将顶点添加到树中
            weight += e.weight();
            if (!marked[v]) visit(g, v);        // 将顶点(v或w)添加到树中
            if (!marked[w]) visit(g, w);
        }
    }

    /**
     * 标记顶点v并将所有连接v和未被标记顶点的边加入pq
     *
     * @param g 加权无向图g
     * @param v 顶点v
     */
    private void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true;
        for (Edge e : g.adj(v)) {
            if (!marked[e.other(v)]) pq.insert(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        LazyPrimMST mst = new LazyPrimMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }
}
