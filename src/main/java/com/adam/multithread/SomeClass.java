package com.adam.multithread;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-07-28 23:53
 **/
public class SomeClass {
    private static class Holder{
        public static final SomeClass s = new SomeClass();
    }

    public static SomeClass get(){
        return Holder.s;
    }

    public String getS(){
        return "111";
    }

    public static void main(String[] args){
        System.out.println(SomeClass.get().getS());
    }
}
