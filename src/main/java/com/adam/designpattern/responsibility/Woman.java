package com.adam.designpattern.responsibility;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-11 23:04
 **/
public class Woman implements IWoman {
    private int type=0;
    private String request="";
    public Woman(int type, String request){
        this.type=type;
        switch (this.type){
            case Handler.FATHER_LEVEL_REQUEST:
                this.request="Dad, could I " + request;
                break;
            case Handler.HUSBAND_LEVEL_REQUEST:
                this.request="Darling, could I " + request;
                break;
            case Handler.SON_LEVEL_REQUEST:
                this.request="Son, could I " + request;
                break;
            default:break;
        }
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
