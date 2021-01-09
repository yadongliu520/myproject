package com.adam.designpattern.facade;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-11 15:41
 **/
public class LetterProcess implements IletterProcess {
    @Override
    public void writeLetter(String context) {
        System.out.println("write letter.Context:" + context);
    }
    @Override
    public void sendLetter(String address) {
        System.out.println("Send letter to address:" + address);
    }
}
