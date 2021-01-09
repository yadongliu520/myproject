package com.adam.designpattern.facade;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-11 15:58
 **/
public class Client {
    public static void main(String[] args) {
        String letterCtx="Hello world.";
        String address="SomeWhere";

        ModenPosteOfficeFacade poster=new ModenPosteOfficeFacade();
        poster.sendLetter(letterCtx,address);
    }


}
