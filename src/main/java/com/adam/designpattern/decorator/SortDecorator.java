package com.adam.designpattern.decorator;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-10 14:36
 **/
public class SortDecorator extends Decorator {
    public SortDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    public void reportSort(){
        System.out.println("Report sort of class.");
    }

    @Override
    public void report(){
        super.report();
        reportSort();
    }
}
