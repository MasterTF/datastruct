package com.ytf.ds.tree.tst;

/**
 * @Program: datastruct
 * @Description: tenary search trie
 * @Author: yutianfang
 * @Date: 19/3/12星期二
 **/
public class TST<V> {
    private Node<V> root;

    public void put(String key, V value){
        root = put(root, key, value, 0);
    }

    private Node<V> put(Node<V> node, String key, V value, int indexOfKey){
        char c = key.charAt(indexOfKey);
        if(node == null) {
            node = new Node<>();
            node.key = c;
        }
        if(c < node.key) node.left = put(node.left, key, value, indexOfKey);
        else if(c > node.key) node.right = put(node.right, key, value, indexOfKey);
        else if(indexOfKey < key.length() - 1) node.mid = put(node.mid, key, value, indexOfKey+ 1);
        else node.value = value;

        return node;
    }
}
