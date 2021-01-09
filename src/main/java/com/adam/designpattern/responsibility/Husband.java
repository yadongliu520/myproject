package com.adam.designpattern.responsibility;


/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-11 22:23
 **/
public class Husband extends Handler {
    public Husband(){
        super(Handler.HUSBAND_LEVEL_REQUEST);
    }
    @Override
    public void reponse(IWoman woman) {
        System.out.println(woman.getRequest() + "--yes.");
    }

}
