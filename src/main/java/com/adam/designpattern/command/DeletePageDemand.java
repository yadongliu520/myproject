package com.adam.designpattern.command;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-24 11:37
 **/
public class DeletePageDemand extends Command {
    @Override
    public void execut() {
        super.pageGroup.find();
        super.pageGroup.delete();
        super.pageGroup.plan();
    }
}
