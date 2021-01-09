package com.adam.designpattern.decorator;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-10 14:34
 **/
public class HighScoreDecorator  extends Decorator{

    public HighScoreDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    public void reportHighScore(){
        System.out.println("Report highest score.");
    }

    @Override
    public void report(){
        this.reportHighScore();
        super.report();
    }
}
