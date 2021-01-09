package com.adam.designpattern.command;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-24 11:38
 **/
public class RequireGroup extends Group{
    @Override
    public void add() {
        System.out.println("Add a plan to RequireGroup");
    }

    @Override
    public void delete() {
        System.out.println("Delete a plan to RequireGroup");
    }

    @Override
    public void change() {
        System.out.println("Change a plan to RequireGroup");
    }

    @Override
    public void find() {
        System.out.println("Find RequireGroup");
    }

    @Override
    public void plan() {
        System.out.println("A plan to RequireGroup");
    }
}
