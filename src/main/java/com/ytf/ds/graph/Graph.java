package com.ytf.ds.graph;

import java.util.List;

/**
 * @Program: datastruct
 * @Description: 无向图
 * @Author: yutianfang
 * @Date: 19/2/23星期六
 **/
public interface Graph {
    // num of vertex
    int v();

    // num of edge
    int e();

    // add edge
    void addEdge(int v, int w);

    // vertices adjacent to v
    List<Integer> adj(int v);
}
