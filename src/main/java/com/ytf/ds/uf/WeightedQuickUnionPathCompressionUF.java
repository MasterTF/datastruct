package com.ytf.ds.uf;

/**
 * @Program: datastruct
 * @Description: 带路径压缩的权重并查集
 * @Author: yutianfang
 * @Date: 2019-08-10
 **/
public class WeightedQuickUnionPathCompressionUF implements UnionFind {
    private int[] parent;
    private int[] size;
    private int count;

    public WeightedQuickUnionPathCompressionUF(int n){
        parent = new int[n];
        size = new int[n];
        count = n;
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }

    }
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if(i == j) return;

        if(size[i] > size[j]){
            parent[j] = i;
            size[i] += size[j];
        }else{
            parent[i] = j;
            size[j] += size[i];
        }
        count--;
    }

    public int find(int p) {
        int root = p;
        while(root != parent[root]) root = parent[root];

        // make every node's parent point to root;
        while(p != root){
            int i = parent[p];
            parent[p] = root;
            p = i;
        }

        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
