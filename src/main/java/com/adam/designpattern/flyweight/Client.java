package com.adam.designpattern.flyweight;

import java.util.Random;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-03 17:42
 **/
public class Client {
    public static void main(String[] args) {
        Random random=new Random();

        for(int i=0;i<4;i++){
            int num=random.nextInt(2)+1;
            String subject="subject" +num;
            String location="location" +num;
            String key=subject +" "+location;
            SignInfoFactory.getSignInfo(key);
        }
    }
}
