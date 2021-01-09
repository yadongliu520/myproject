package com.adam.designpattern.component.tree;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-06 08:53
 **/
public class Branch extends Node {
    private ArrayList<Node> children =new ArrayList<>();
    public Branch(Object data) {
        super(data);
    }

    public void addChild(Node child){
        child.setParent(this);
        this.children.add(child);
    }

    public ArrayList<Node> getChildren() {
        return children;
    }
}
