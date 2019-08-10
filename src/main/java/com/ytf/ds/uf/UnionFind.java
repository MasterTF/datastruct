package com.ytf.ds.uf;

public interface UnionFind {
    void union(int i, int j);

    int find(int i);

    boolean connected(int i, int j);

    int count();
}
