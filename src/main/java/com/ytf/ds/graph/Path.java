package com.ytf.ds.graph;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Program: datastruct
 * @Description: 路径
 * @Author: yutianfang
 * @Date: 2019-08-17
 **/
public class Path {
    private boolean[] marked;
    private int[] eagleTo;
    private int s;
    private static final int DFS = 1;
    public Path(Graph g, int v, int type){
        marked = new boolean[g.v()];
        eagleTo = new int[g.v()];
        s = v;
        if(type == DFS) dfs(g, v);
        else            bfs(g, v);
    }

    private void bfs(Graph g, int s) {
        Queue<Integer> queue = new ArrayBlockingQueue<>(g.v());
        queue.add(s);
        marked[s] = true;

        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int w : g.adj(v)){
                if(marked[w]) continue;

                queue.add(w);
                marked[w] = true;
                eagleTo[w] = v;
            }
        }
    }

    private void dfs(Graph g, int s){
        marked[s] = true;
        for(int w : g.adj(s)){
            if(!marked[w]) {
                dfs(g, w);
                eagleTo[w] = s;
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();

        for(int i = v; i != s; i = eagleTo[i])  path.push(i);
        path.push(s);

        return path;
    }

    public Iterable<Integer> topologicalSort(Graph g){
        Stack<Integer> reversePost = new Stack<>();
        for(int v = 0; v < g.v(); v++)  if(!marked[v]) topoDfs(g, v, reversePost);
        return reversePost;
    }

    private void topoDfs(Graph g, int v, Stack<Integer> reversePost){
        marked[v] = true;
        for(int w : g.adj(v))
            if(!marked[w])  dfs(g, w);
        reversePost.add(v);
    }

}
