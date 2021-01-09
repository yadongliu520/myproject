package com.adam.designpattern.responsibility.before;

import com.adam.designpattern.responsibility.IWoman;

import java.util.Random;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-11 22:25
 **/
public class Client {
    public static void main(String[] args) {
        Random random=new Random();
        Handler father=new Father();
        Handler husband=new Husband();
        Handler son=new Son();
        for(int i=0;i<4;i++){
            IWoman woman=new Woman(random.nextInt(3)+1,"do smt.");
            if(woman.getType()==1){
                father.handleMsg(woman);
            }else if(woman.getType()==2){
                husband.handleMsg(woman);
            }else if(woman.getType()==3)
                son.handleMsg(woman);
            else {}
        }
    }
}
