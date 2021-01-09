package com.adam.designpattern.decorator;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-10 14:30
 **/
public abstract class Decorator extends SchoolReport {
    private SchoolReport schoolReport;
    public Decorator(SchoolReport schoolReport){
       this.schoolReport=schoolReport;
    }

    @Override
    public void report() {
        schoolReport.report();
    }

    @Override
    public void sign() {
        schoolReport.sign();
    }
}
