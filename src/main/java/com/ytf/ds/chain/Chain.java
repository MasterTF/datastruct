package com.ytf.ds.chain;

import java.util.Objects;

/**
 * Created by yutianfang
 * DATE: 17/12/5星期二.
 */
public class Chain<T> extends AbstractChain<T> {
    @Override
    public Node<T> insert(int pos, T value) {
        if (pos < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = first;
        for (int i = 1; i < pos && current != null; i++) {
            current = current.getNext();
        }

        // 越界
        if (pos > 0 && current == null) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = new Node<T>(value);
        // 第一个元素
        if (pos == 0) {
            node.setNext(first);
            first = node;
        } else {
            node.setNext(current.getNext());
            current.setNext(node);
        }

        return node;
    }

    @Override
    public Node<T> delete(int pos) {
        if(pos < 1){
            throw new IndexOutOfBoundsException();
        }

        Node<T> pre = null;
        Node<T> current = first;
        for(int i = 1; i < pos && current != null; i++){
            pre = current;
            current = current.getNext();
        }

        if(Objects.isNull(current)){
            throw new IndexOutOfBoundsException();
        }

        if(pos == 1){
            first = first.getNext();
        }else {
            pre.setNext(current.getNext());
            current.setNext(null);
        }

        return current;
    }

    @Override
    public Node<T> find(int pos) {
        if(pos < 1 || Objects.isNull(first)){
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = first;
        for(int i = 1; i < pos && !Objects.isNull(current); i++){
            current = current.getNext();
        }

        if(Objects.isNull(current)){
            throw new IndexOutOfBoundsException();
        }

        return current;
    }

    @Override
    public int length() {
        int length = 0;
        Node<T> current = first;
        while (current != null && length < Integer.MAX_VALUE){
            length++;
            current = current.getNext();
        }

        return length;
    }

    @Override
    public Chain<T> append(T value) {
        Node<T> node = new Node<>(value);
        if(first == null){
            first = node;
            return this;
        }

        Node<T> current = first;
        while(current.getNext() != null){
            current = current.getNext();
        }

        current.setNext(node);
        return this;
    }
}
