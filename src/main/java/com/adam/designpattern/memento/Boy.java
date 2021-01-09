package com.adam.designpattern.memento;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-26 23:36
 **/
public class Boy {
    private String state;
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento getMemento() {
        return new Memento(this.state);
    }

    public void restoreMemento(Memento memento) {
      this.setState(memento.getState());
    }

    public void changeState(){
        this.setState("I am not fine.");
    }

    public Memento2 getMemento2() {
        return new Memento2(this.state);
    }

    public void restoreMemento2(IMemento2 memento2) {
        this.setState(((Memento2)memento2).getState());
    }

    //封装得更好
    private class Memento2 implements IMemento2 {
        private String state;
        private Memento2(String state){
            this.state=state;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
}
