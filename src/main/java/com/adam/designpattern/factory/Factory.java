package com.adam.designpattern.factory;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-18 08:29
 **/
public class Factory extends AbstractFactory {
    @Override
    public <T extends IHuman> T createHuman(Class<T> clasz)  {
      IHuman human = null;
       try{
             human=clasz.newInstance();
             //human=(T)Class.forName(clasz.getName()).newInstance();
       }catch (Exception e){}
        return (T)human;
    }
}
