package com.adam.designpattern.command;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-24 11:36
 **/
public class AddRequireCommand extends Command {
    @Override
    public void execut() {
        super.requireGroup.find();
        super.requireGroup.add();
        super.requireGroup.plan();
        super.codeGroup.find();
        super.codeGroup.add();
        super.codeGroup.plan();
    }
}
