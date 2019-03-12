package com.ytf.ds.chain;

/**
 * Created by yutianfang
 * DATE: 17/12/5星期二.
 */
public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(){

    }

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node setValue(T value) {
        this.value = value;
        return this;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node setNext(Node<T> next) {
        this.next = next;
        return this;
    }
}
