package com.ytf.ds.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: datastruct
 * @Description: 有向图
 * @Author: yutianfang
 * @Date: 2019-08-17
 **/
public class Digraph implements Graph {
    private int v;
    private List<List<Integer>> adj;

    public Digraph(int v){
        this.v = v;
        adj = new ArrayList<>(v);
        for(int i = 0; i < v; i++)  adj.add(new ArrayList<>());
    }

    @Override
    public int v() {
        return v;
    }

    @Override
    public int e() {
        int count = 0;
        for(List<Integer> edges : adj) count += edges.size();
        return count;
    }

    @Override
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    @Override
    public List<Integer> adj(int v) {
        return adj.get(v);
    }
}
