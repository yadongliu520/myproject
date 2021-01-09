package com.adam.designpattern.observer;

import com.adam.multithread.ThreadState;

import java.util.Observer;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-07 22:41
 **/
public class Client {
    public static void main(String[] args) {
        Hanfeizi hanfeizi=new Hanfeizi();
        IObserver lisi = new Lisi();
        IObserver zhangsi= new Zhangsi();
        hanfeizi.attach(lisi);
        //hanfeizi.attach(zhangsi);
        hanfeizi.haveBreakfast();
        hanfeizi.haveFun();
        hanfeizi.threadShutDown();
    }
}
