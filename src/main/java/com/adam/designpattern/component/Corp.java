package com.adam.designpattern.component;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-26 12:14
 **/
public abstract class Corp {
    private String name;
    private int salary;
    private String job;
    private Corp parent=null;
    public Corp(String name,int salary, String job){
        this.name=name;
        this.salary=salary;
        this.job=job;
    }
    public  String getInfo(){
        String info=String.format("Name: %s;Salary: %d;Job: %s", this.name, this.salary, this.job);
        return info;
    }

    public Corp getParent() {
        return parent;
    }

    public void setParent(Corp parent) {
        this.parent = parent;
    }
}
