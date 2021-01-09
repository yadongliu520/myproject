package com.adam.designpattern.component.tree;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-06 08:51
 **/
public abstract class Node<T> {
    private T data;
    private Node parent;
    public Node(T data){
        this.data=data;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
