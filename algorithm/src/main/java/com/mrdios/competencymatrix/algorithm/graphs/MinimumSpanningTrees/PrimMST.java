package com.mrdios.competencymatrix.algorithm.graphs.MinimumSpanningTrees;

import com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.queue.Queue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * 最小生成树的Prim算法-即时版本
 *
 * @author MrDios
 * @date 2017-05-17
 */
public class PrimMST {
    private Edge[] edgeTo;          // 距离树最近的边
    private double[] distTo;        // distTo[w]=edgeTo[w].weight()
    private boolean[] marked;       // 如果v在树中则为true
    private IndexMinPQ<Double> pq;  // 有效的横切边

    public PrimMST(EdgeWeightedGraph g) {
        edgeTo = new Edge[g.V()];
        distTo = new double[g.V()];
        marked = new boolean[g.V()];
        for (int v = 0; v < g.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPQ<>(g.V());

        distTo[0] = 0.0;
        pq.insert(0, 0.0);    // 用顶点0和权重0初始化pq
        while (!pq.isEmpty()) {
            visit(g, pq.delMin());  // 将最近的顶点添加到树中
        }
    }

    /**
     * 将顶点v添加到树中，更新数据
     *
     * @param g 加权无向图
     * @param v 顶点v
     */
    private void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true;
        for (Edge e : g.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;// v-w失效
            if (e.weight() < distTo[w]) {
                edgeTo[w] = e;      // 连接w和树的最佳边Edge变为e

                distTo[w] = e.weight();
                if (pq.contains(w)) pq.change(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges() {
        Queue<Edge> mst = new Queue<>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
    }

    public double weight() {
        double weight = 0d;
        for (Edge e : edges()) {
            weight += e.weight();
        }
        return weight;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        PrimMST mst = new PrimMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }
}
