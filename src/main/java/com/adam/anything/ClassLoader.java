package com.adam.anything;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-13 16:08
 **/
public class ClassLoader {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.getClass().getMethod("add",Object.class).invoke(arr, "hello"); //泛型类型擦出

        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }

    }
 }
