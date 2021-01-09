package com.adam.designpattern.vistor;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-27 23:59
 **/
public class Manager extends Employee {
    private String performance;

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    protected String getOtherInfo() {
        return "Performance: " + this.performance;
    }

    @Override
    public void accept(IVistor vistor) {
        vistor.visit(this);
    }
}
