package com.adam.multithread;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-07-27 23:17
 **/
public class VolatileExample {
    int a=0;
    volatile boolean flag=false;
    public void writer(){
        a=1;
        flag=true;
    }
    public void reader(){
        if(flag){
            a=2;
        }
        System.out.println(String.format("a=%s", a));
    }
}
