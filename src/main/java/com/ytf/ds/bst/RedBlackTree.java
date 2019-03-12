package com.ytf.ds.bst;

/**
 * @Program: datastruct
 * @Description:
 * @Author: yutianfang
 * @Date: 19/2/17星期日
 **/
public class RedBlackTree<K extends Comparable<K>, V> implements BST<K, V> {
    public static boolean RED = true, BLACK = false;

    private Node<K, V> root;

    public Node<K, V> put(Node<K,V> node, K key, V value) {
        // 找到新节点的父节点
        if(node == null)                        return new Node<>(key, value, RED);
        else if(key.compareTo(node.key) < 0)    node.left = put(node.left, key, value);
        else if(key.compareTo(node.key) > 0)    node.right = put(node.right, key, value);
        else                                    node.value = value;

        if(isRed(node.right) && !isRed(node.left))      node = rotateLeft(node);  //红色在左边
        if(isRed(node.left) && isRed((node.left.left))) node = rotateRight(node); //平衡4-node
        if(isRed(node.left) && isRed(node.right))       node = flipColor(node);   //分割4-node

        return node;
    }

    @Override
    public Node<K, V> put(K key, V value){
        root = put(root, key, value);
        return root;
    }

    @Override
    public V get(K key) {
        Node<K, V> node = root;
        while(node != null){
            if(key.compareTo(node.key) < 0)         node = node.left;
            else if(key.compareTo(node.key) > 0)    node = node.right;
            else                                    return node.value;
        }
        return null;
    }


    private Node<K, V> rotateLeft(Node<K, V> curr){
        assert isRed(curr.right);
        Node<K, V> right = curr.right;

        curr.right = right.left;
        right.left = curr;
        right.color = curr.color;
        curr.color = RED;
        return right;
    }

    private Node<K, V> rotateRight(Node<K, V> curr){
        assert isRed(curr.left);
        Node<K, V> left = curr.left;

        curr.left = left.right;
        left.right = curr;
        left.color = curr.color;
        curr.color = RED;
        return left;
    }

    private Node<K, V> flipColor(Node<K, V> curr){
        assert isRed(curr.left);
        assert isRed(curr.right);

        curr.left.color = BLACK;
        curr.right.color = BLACK;
        curr.color = RED;
        return curr;
    }

    private boolean isRed(Node<K,V> node){
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }
}
