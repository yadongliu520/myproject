package com.adam.designpattern.command;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-24 11:23
 **/
public class CodeGroup extends Group{

    @Override
    public void add() {
        System.out.println("Add a plan to codeGroup");
    }

    @Override
    public void delete() {
        System.out.println("Delete a plan to codeGroup");
    }

    @Override
    public void change() {
        System.out.println("Change a plan to codeGroup");
    }

    @Override
    public void find() {
        System.out.println("Find codeGroup");
    }

    @Override
    public void plan() {
        System.out.println("A plan to codeGroup");
    }
}
