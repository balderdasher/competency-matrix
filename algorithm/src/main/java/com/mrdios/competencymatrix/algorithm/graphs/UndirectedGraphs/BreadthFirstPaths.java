package com.mrdios.competencymatrix.algorithm.graphs.UndirectedGraphs;

import com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.queue.Queue;
import com.mrdios.competencymatrix.algorithm.fundamentals.StacksAndQueues.stack.Stack;

/**
 * 使用广度优先搜索查找图中的路径
 *
 * @author huxiong
 * @date 2017-05-05 15:28
 */
public class BreadthFirstPaths {
    private boolean[] marked;       // 到达该顶点的最短路径已知吗？
    private int[] edgeTo;           // 到达该顶点的已知路径上的最后一个顶点
    private final int s;            // 起点

    public BreadthFirstPaths(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        bfs(g, s);
    }

    private void bfs(Graph g, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;   // 标记起点
        queue.enqueue(s);   // 将起点加入队列
        while (!queue.isEmpty()) {
            int v = queue.dequeue();    // 从队列中删去下一顶点
            for (int w : g.adj(v)) {
                if (!marked[w]) {        // 对于每个未被标记的相邻顶点
                    edgeTo[w] = v;      // 保存最短路径的最后一条边
                    marked[w] = true;   // 标记它，因为最短路径已知
                    queue.enqueue(w);   // 并将它添加到队列中
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        return path;
    }
}
