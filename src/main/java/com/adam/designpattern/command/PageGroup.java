package com.adam.designpattern.command;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-24 11:38
 **/
public class PageGroup extends Group {
    @Override
    public void add() {
        System.out.println("Add a plan to PageGroup");
    }

    @Override
    public void delete() {
        System.out.println("Delete a plan to PageGroup");
    }

    @Override
    public void change() {
        System.out.println("Change a plan to PageGroup");
    }

    @Override
    public void find() {
        System.out.println("Find PageGroup");
    }

    @Override
    public void plan() {
        System.out.println("A plan to PageGroup.");
    }
}
