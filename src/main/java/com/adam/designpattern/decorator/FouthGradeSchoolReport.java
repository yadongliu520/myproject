package com.adam.designpattern.decorator;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-10 14:29
 **/
public class FouthGradeSchoolReport  extends SchoolReport{
    @Override
    public void report() {
        System.out.println("Report scores.");
    }

    @Override
    public void sign() {
        System.out.println("The family Sign: zhangsan.");
    }
}
