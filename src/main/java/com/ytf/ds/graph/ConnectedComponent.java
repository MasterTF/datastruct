package com.ytf.ds.graph;

/**
 * @Program: datastruct
 * @Description: 识别图中哪些顶点是连通的
 * @Author: yutianfang
 * @Date: 2019-08-17
 **/
public class ConnectedComponent {
    private boolean[] marked;
    private int[] id;// every vertex's component num
    private int count; // total component

    public ConnectedComponent(Graph g){
        marked  = new boolean[g.v()];
        id      = new int[g.v()];
        for(int v = 0; v < g.v(); v++){
            if(marked[v]) continue;;
            dfs(g, v);
            count++;
        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        id[v] = count;

        for(int w : g.adj(v)){
            if(marked[w]) continue;
            dfs(g, w);
        }
    }

}
