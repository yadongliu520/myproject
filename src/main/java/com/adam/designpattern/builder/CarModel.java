package com.adam.designpattern.builder;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-20 22:41
 **/
public abstract  class CarModel {
    protected abstract  void start();
    protected abstract  void alarm();
    protected abstract  void boom();
    protected abstract  void stop();

    public final void run(){
        for (String s :seq) {
            if(s.equals("start"))this.start();
            else if (s.equals("alarm")) this.alarm();
            else if (s.equals("boom"))this.boom();
            else if (s.equals("stop"))this.stop();
        }
    }
    private ArrayList<String> seq;
    public  void setSeq(ArrayList<String> seq){
        this.seq=seq;
    }
}
