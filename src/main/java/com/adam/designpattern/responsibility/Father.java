package com.adam.designpattern.responsibility;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-11 23:05
 **/
public class Father extends Handler {
    public Father() {
        super(Handler.FATHER_LEVEL_REQUEST);
    }

    @Override
    protected void reponse(IWoman woman) {
        System.out.println( woman.getRequest() + "--yes.");
    }
}
