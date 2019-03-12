package com.ytf.ds.bst;

/**
 * @Program: datastruct
 * @Description: 平衡搜索树节点
 * @Author: yutianfang
 * @Date: 19/2/17星期日
 **/
public class Node<K, V> {

    public K key;
    public V value;
    public Node<K, V> left;
    public Node<K, V> right;
    public boolean color;

    public Node(K key, V value, boolean color){
        this.key = key;
        this.value = value;
        this.color = color;
    }

}
