package com.ytf.ds.uf;

/**
 * @Program: datastruct
 * @Description: 带权重优化的并查集
 * @Author: yutianfang
 * @Date: 2019-08-05
 **/
public class WeightedQuickUnionUF implements UnionFind{
    private int[] parent; // parent[i]  = parent of i
    private int[] size;   // size[i]    = number of sites in subtree rooted at i
    private int   count;  // number of components

    public WeightedQuickUnionUF(int n){
        count   = n;
        parent  = new int[n];
        size    = new int[n];
        for(int i = 0; i < n; i++){
            parent[i]   = i;
            size[i]     = 1;
        }
    }

    public int find(int p){
        while(p != parent[p]) p = parent[p];
        return p;
    }

    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i == j) return;

        if(size[i] < size[j]) {
            parent[i] = j;
            size[j] += size[i];
        }
        else                    {
            parent[j] = i;
            size[i] += size[j];
        }
        count--;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int count(){
        return count;
    }
}
