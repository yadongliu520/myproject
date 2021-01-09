package com.adam.designpattern.memento;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-26 23:39
 **/
public class CareTaker {
    private Memento memento;
    private IMemento2 memento2;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    public IMemento2 getMemento2() {
        return memento2;
    }

    public void setMemento2(IMemento2 memento2) {
        this.memento2 = memento2;
    }
}
