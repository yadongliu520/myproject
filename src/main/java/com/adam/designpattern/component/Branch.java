package com.adam.designpattern.component;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-26 12:17
 **/
public class Branch extends Corp {
    private ArrayList<Corp> subordinateList =new ArrayList<>();

    public Branch(String name, int salary, String job){
        super(name,salary,job);
    }


    public void addSubordinate(Corp corp){
        corp.setParent(this);
        this.subordinateList.add(corp);
    }

    public ArrayList<Corp> getSubordinateList() {
        return this.subordinateList;
    }
}
