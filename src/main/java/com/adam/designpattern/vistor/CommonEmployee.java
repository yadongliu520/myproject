package com.adam.designpattern.vistor;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-27 23:49
 **/
public class CommonEmployee extends Employee {
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    protected String getOtherInfo() {
        String info="Job:" + this.job;
        return info;
    }

    @Override
    public void accept(IVistor vistor) {
        vistor.visit(this);
    }
}
