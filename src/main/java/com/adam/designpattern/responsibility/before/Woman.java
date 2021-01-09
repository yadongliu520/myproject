package com.adam.designpattern.responsibility.before;

import com.adam.designpattern.responsibility.IWoman;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-11 22:16
 **/
public class Woman implements IWoman {
    private int type=0;
    private String request="";
    public Woman(int type, String request){
        this.type=type;
        this.request=request;
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String getRequest() {
        return request;
    }
}
