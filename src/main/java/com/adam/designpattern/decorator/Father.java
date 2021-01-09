package com.adam.designpattern.decorator;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-10 14:46
 **/
public class Father {
    public static void main(String[] args) {
        SchoolReport schoolReport=new FouthGradeSchoolReport();
        Decorator sort = new SortDecorator(schoolReport);
        Decorator highScore=new HighScoreDecorator(sort);
        highScore.report();
        highScore.sign();
    }
}
