package com.adam.designpattern.responsibility;



/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-11 22:22
 **/
public class Son extends Handler {
    public Son() {
        super(Handler.SON_LEVEL_REQUEST);
    }

    @Override
    public void reponse(IWoman woman) {
        System.out.println(woman.getRequest() + "--yes.");
    }
}
