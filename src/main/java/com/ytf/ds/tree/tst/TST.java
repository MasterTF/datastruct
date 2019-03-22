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

    public Node<V> get(String key){
        Node<V> node = get(root, key, 0);
        if(node == null) return null;
        return node;
    }

    private Node<V> put(Node<V> node, String key, V value, int indexOfKey){
        char c = key.charAt(indexOfKey);
        if(node == null) {
            node = new Node<>();
            node.key = c;
        }
        if(c < node.key)                        node.left = put(node.left, key, value, indexOfKey);
        else if(c > node.key)                   node.right = put(node.right, key, value, indexOfKey);
        else if(indexOfKey < key.length() - 1)  node.mid = put(node.mid, key, value, indexOfKey+ 1);
        else node.value = value;

        return node;
    }

    private Node<V> get(Node<V> node, String key, int indexOfKey){
        if(node == null)                            return null;
        char ch = key.charAt(indexOfKey);
        if(ch > node.key)                           return get(node.right, key, indexOfKey);
        else if(ch < node.key)                      return get(node.left, key, indexOfKey);
        else if(indexOfKey < key.length() - 1)      return get(node.mid, key, indexOfKey + 1);
        else                                        return node;
    }
}
