package com.adam.designpattern.memento;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-26 23:48
 **/
public class Client {
    public static void main(String[] args) {
        Boy boy=new Boy();
        CareTaker careTaker=new CareTaker();
        boy.setState("I am fine");
        System.out.println("The state of boy before change: " + boy.getState());
        careTaker.setMemento(boy.getMemento());
        boy.changeState();
        System.out.println("The state of boy after change: " + boy.getState());
        boy.restoreMemento(careTaker.getMemento());
        System.out.println("The state of boy after restore: " + boy.getState());

        SimpleBoy boy1=new SimpleBoy();
        boy1.setState("I am fine");
        System.out.println("The state of boy before change: " + boy1.getState());
        boy1.createMemento();
        boy1.changeState();
        System.out.println("The state of boy after change: " + boy1.getState());
        boy1.restoreMemento();
        System.out.println("The state of boy after restore: " + boy1.getState());

        Boy boy2=new Boy();
        CareTaker careTaker2=new CareTaker();
        boy2.setState("I am fine");
        System.out.println("The state of boy before change: " + boy2.getState());
        careTaker2.setMemento2(boy2.getMemento2());
        boy2.changeState();
        System.out.println("The state of boy after change: " + boy2.getState());
        boy2.restoreMemento2(careTaker2.getMemento2());
        System.out.println("The state of boy after restore: " + boy2.getState());


    }

}
