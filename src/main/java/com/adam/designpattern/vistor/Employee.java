package com.adam.designpattern.vistor;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-27 23:49
 **/
public abstract class Employee {
    private String name;
    private int sex;
    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    protected abstract String getOtherInfo();

    public abstract  void accept(IVistor vistor);

}
