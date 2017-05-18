package com.mrdios.competencymatrix.algorithm.graphs.MinimumSpanningTrees;

/**
 * 带权重的边的数据类型（加权边）
 *
 * @author huxiong
 * @date 2017-05-17 11:37
 */
public class Edge implements Comparable<Edge> {
    private final int v;        // 顶点之一
    private final int w;        // 另一个顶点
    private final double weight;// 边的权重

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 边的权重
     *
     * @return 边的权重
     */
    public double weight() {
        return weight;
    }

    /**
     * 边的一个顶点
     *
     * @return 边的一个顶点
     */
    public int either() {
        return v;
    }

    /**
     * 边的另一个顶点
     *
     * @return 边的另一个顶点
     */
    public int other(int vertex) {
        if (vertex == v) {
            return w;
        } else if (vertex == w) {
            return v;
        } else {
            throw new RuntimeException("Inconsistent edge");
        }
    }

    @Override
    public int compareTo(Edge that) {
        if (this.weight() < that.weight()) return -1;
        else if (this.weight() > that.weight()) return +1;
        else return 0;
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }

}
