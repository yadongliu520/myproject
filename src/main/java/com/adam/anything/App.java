package com.adam.anything;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-26 20:08
 **/
public class App {
    public static long getWindowStartWithOffset(long timestamp, long offset, long windowSize) {
        return timestamp - (timestamp - offset + windowSize) % windowSize;
    }


    public static void main(String[] args) {
//        Integer a=10;
//
//        ArrayList arr = new ArrayList();
//        //System.out.println(arr.get(1));
////        System.out.println(Integer.toBinaryString(a));
////        System.out.println(Integer.toBinaryString(-a));
////        System.out.println(Integer.toBinaryString(~a));
////        System.out.println(Integer.toBinaryString(~-a));
////        boolean b=true;
////        assert !b;
//        int b=7;
////        System.out.println(b&10);
////        System.out.println(b&10-1);//等价b&9
////        System.out.println(Math.abs(b&-b));//判断2的次方
////        System.out.println(Math.abs(-b));
//        int[] arr2= new int[]{1};
//        System.out.println(arr2[0]);L

        // System.out.println(getWindowStartWithOffset(1611589521, 0, 2 ));
        // System.out.println(1611589521%2);
        System.out.println(Integer.parseInt("4118641136"));

    }
}
//1000, 10111