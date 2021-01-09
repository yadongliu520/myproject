package com.adam.designpattern.command;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-24 11:09
 **/
public abstract class Command {
    protected CodeGroup codeGroup=new CodeGroup();
    protected RequireGroup requireGroup =new RequireGroup();
    protected PageGroup pageGroup=new PageGroup();

    public abstract void execut();
}
