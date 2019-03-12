package com.ytf.ds.bst;

public interface BST<K, V> {
    Node<K, V> put(K key, V value);

    V get(K key);
}
