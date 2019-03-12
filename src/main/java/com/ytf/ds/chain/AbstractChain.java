package com.ytf.ds.chain;

/**
 * Created by yutianfang
 * DATE: 17/12/5星期二.
 */
public abstract class AbstractChain<T> {

    protected Node<T> first;

    abstract Node<T> insert(int pos, T value);

    abstract Node<T> delete(int pos);

    abstract Node<T> find(int pos);

    abstract int length();

    abstract Chain<T> append(T value);

    @Override
    public String toString(){
        StringBuilder value = new StringBuilder();
        for(Node<T> current = first; current != null; current = current.getNext()){
            value.append(current.getValue()).append(" ");
        }
        return value.toString();
    }

}
