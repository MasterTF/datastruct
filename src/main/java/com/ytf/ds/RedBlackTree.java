package com.ytf.ds;

import com.ytf.ds.bst.BST;
import com.ytf.ds.bst.Node;

/**
 * @Program: datastruct
 * @Description: 红黑树
 * @Author: yutianfang
 * @Date: 19/3/4星期一
 **/
public class RedBlackTree<K extends Comparable<K>, V> implements BST<K, V> {

    private Node<K, V> root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    @Override
    public Node<K, V> put(K key, V value) {
        root = put(root, key, value);
        return root;
    }

    @Override
    public V get(K key) {
        Node<K, V> current = root;
        while(current != null){
            if(key.compareTo(current.key) < 0) current = current.left;
            else if(key.compareTo(current.key) > 0) current = current.right;
            else return current.value;
        }
        return null;
    }

    private Node<K, V> put(Node<K, V> node, K key, V value){
        if(node == null) return new Node<>(key, value, RED);

        if(key.compareTo(node.key) < 0) node.left = put(node.left, key, value);
        else if(key.compareTo(node.key) > 0) node.right = put(node.right, key, value);
        else node.value = value;

        if(isRed(node.right) && !isRed(node.left)) node = rotateLeft(node); // left-leaning
        if(isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);// balance 4-node
        if(isRed(node.left) && isRed(node.right)) node = flip(node);// split 4-node

        return node;
    }

    private boolean isRed(Node<K, V> node){
        if(node == null) return false;
        return node.color;
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

    private Node<K, V> flip(Node<K, V> curr){
        assert isRed(curr.left);
        assert isRed(curr.right);

        curr.left.color = BLACK;
        curr.right.color = BLACK;
        curr.color = RED;
        return curr;
    }
}
