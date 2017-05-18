package com.mrdios.competencymatrix.algorithm.graphs.DirectedGraphs;

import com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.bag.Bag;

/**
 * 有向图
 *
 * @author huxiong
 * @date 2017-05-15 10:26
 */
public class Digraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int V;        // 顶点数量
    private int E;              // 边的数量
    private Bag<Integer>[] adj; // 与该顶点连接的顶点

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /**
     * 添加一条由顶点v到w的边
     *
     * @param v 顶点v
     * @param w 顶点w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * 反转有向图中所有边的指向
     *
     * @return 反转后的有向图
     */
    public Digraph reverse() {
        Digraph h = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                h.addEdge(w, v);
            }
        }
        return h;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
