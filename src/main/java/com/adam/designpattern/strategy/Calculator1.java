package com.adam.designpattern.strategy;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-08 23:41
 **/
public class Calculator1 {
    private final static String OPERATOR_ADD="+";
    private final static String OPERATOR_SUB="-";
    public int exec(int a, int b, String operator){
        int result=0;
       if(operator=="+"){
            result=add(a,b);
       }else if(operator=="-"){
            result=sub(a,b);
       }
       return result;
    }
    public int add(int a, int b){
        return a+b;
    }
    public int sub(int a,int b){
        return a-b;
    }
}
