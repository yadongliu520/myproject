package com.adam.designpattern.prototype;

import java.util.Random;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-21 22:41
 **/
public class Client {
    public static void sendMail(Mail mail){
        System.out.println(String.format("Send mail: The mail tile is %s; The mail context is %s; The address is %s",
                mail.getSubject(),mail.getContext(), mail.getAddress()));
    }
    public static void main(String[] args) {
        Mail mail=new Mail();
        Random random=new Random();
        for(int i=0;i<10;i++){
            Mail mail1=mail.clone();
            mail1.setAddress("Address " + random.nextInt(10));
            sendMail(mail1);
        }

    }
}
