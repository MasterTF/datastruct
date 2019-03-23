package com.ytf.ds.tree.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Program: datastruct
 * @Description: trie树
 * @Author: yutianfang
 * @Date: 19/3/22星期五
 **/
public class Trie {
    private Node root;
    private int r;
    /** Initialize your data structure here. */
    public Trie(int r) {
        this.r = r;
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        root = put(root, word, true, 0);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = get(root, word, 0);
        if(node == null) return false;
        return node.value;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public List<String> startsWith(String prefix) {
        List<String> list = new ArrayList<>();
        Node node = get(root, prefix, 0);
        collect(node, prefix, list);


        return list;
    }

    public String longestPrefixOf(String query){
        int length = search(root, query, 0, 0);
        return query.substring(0, length);
    }

    private int search(Node node, String query, int indexOfKey, int length){
        if(node == null)                    return length;
        if(node.value)                      length = indexOfKey;
        if(indexOfKey == query.length())    return length;
        char ch = query.charAt(indexOfKey);
        return  search(node.next[ch - 'a'], query, indexOfKey + 1, length);
    }

    private Node put(Node node, String key, Boolean value, int indexOfKey){
        if(node == null) node = new Node();
        if(indexOfKey == key.length()){
            node.value = value;
            return node;
        }

        char ch = key.charAt(indexOfKey);
        node.next[ch - 'a'] = put(node.next[ch - 'a'], key, value, indexOfKey + 1);
        return node;

    }

    private Node get(Node node, String key, int indexOfKey){
        if(node == null) return null;
        if(indexOfKey == key.length()) return node;
        char ch = key.charAt(indexOfKey);
        return get(node.next[ch - 'a'], key, indexOfKey + 1);
    }

    private void collect(Node node, String prefix, List<String> list){
        if(node == null) return;
        if(node.value) list.add(prefix);
        for(char ch = 0; ch < 26; ch++){
            collect(node.next[ch], prefix + Character.toString((char)(ch +'a')), list);
        }
    }

    class Node{
        Node[] next = new Node[r];
        boolean value;
    }
}


