package com.adam.designpattern.responsibility;

import java.util.Random;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-11 23:46
 **/
public class Client {
    public static void main(String[] args) {
        Handler father=new Father();
        Handler husband=new Husband();
        Handler son=new Son();
        father.setNextHandler(husband);
        husband.setNextHandler(son);
        Random random=new Random();
        for(int i=0;i<5;i++){
            int type=random.nextInt(5)+1;
            System.out.println("type: "+ type);
            IWoman woman=new Woman(type,"do smt.");
            father.handleMsg(woman);
        }
    }
}
