package com.adam.designpattern.memento;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-26 23:37
 **/
public class Memento {
    private String state;
    public Memento(String state){
        this.state=state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
