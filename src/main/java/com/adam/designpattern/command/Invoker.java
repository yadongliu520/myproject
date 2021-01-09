package com.adam.designpattern.command;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-24 11:11
 **/
public class Invoker{
    private Command command;
    public Invoker(Command command){
        this.command=command;
    }

    public void action(){
        this.command.execut();
    }
}
