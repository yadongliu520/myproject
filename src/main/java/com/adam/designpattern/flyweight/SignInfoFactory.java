package com.adam.designpattern.flyweight;

import java.util.HashMap;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-03 17:35
 **/
public class SignInfoFactory {
    private static HashMap<String,SignInfo> pool=new HashMap<>();

    @Deprecated
    public static SignInfo getSignInfo(){
        return  new SignInfo();
    }

    public static SignInfo getSignInfo(String key){
       SignInfo result=null;
       if(!pool.containsKey(key)){
           System.out.println("Create object and put into the pool.");
           result=new SignInfo4Pool(key);
           pool.put(key,result);
       }else {
           result=pool.get(key);
           System.out.println("Get from the pool");
       }
       return result;
    }
}
