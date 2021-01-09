package com.adam.designpattern.prototype;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-21 22:31
 **/
public class Mail implements Cloneable {
    private String subject="Bless";
    private String context="Happy New year";
    private String address="address";

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubject() {
        return subject;
    }

    public String getContext() {
        return context;
    }

    public String getAddress() {
        return address;
    }


    @Override
    public Mail clone(){
        Mail mail=null;
       try{
           mail= (Mail) super.clone();
       }catch (Exception e){
           e.printStackTrace();
       }
       return mail;
    }
}
