package com.adam.designpattern.command;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-24 11:33
 **/
public class Client {
    public static void main(String[] args) {
        Command command=new AddRequireCommand();
        Invoker invoker=new Invoker(command);
        invoker.action();
    }
}
