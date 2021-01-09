package com.adam.designpattern.factory;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-18 17:53
 **/
public class SimpleFactory {
    public static <T extends IHuman> T createHuman(Class<T> clasz){
        IHuman human=null;
        try{
            human=clasz.newInstance();
        }catch (Exception e){}
        return (T)human;
    }
}
