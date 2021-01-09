package com.adam.designpattern.adapter;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-25 14:58
 **/
public class Client {
    public static void main(String[] args) {
        Target adapter=new Adapter();
        adapter.request();
    }
}
