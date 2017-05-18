package com.mrdios.competencymatrix.algorithm.graphs.MinimumSpanningTrees;

import com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.queue.Queue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

/**
 * 最小生成树的Kruskal算法
 *
 * @author MrDios
 * @date 2017-05-18
 */
public class KruskalMST {
    private double weight;                          // 生成树的权重
    private Queue<Edge> mst = new Queue<>();        // 最小生成树中的边

    public KruskalMST(EdgeWeightedGraph g) {
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge e : g.edges()) {
            pq.insert(e);
        }

        // 贪婪算法
        UF uf = new UF(g.V());
        while (!pq.isEmpty() && mst.size() < g.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) {              // 忽略失效边
                uf.union(v, w);                     // 合并子树
                mst.enqueue(e);
                weight += e.weight();
            }
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
        KruskalMST mst = new KruskalMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }
}
