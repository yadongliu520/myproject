package com.adam.designpattern.facade;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-11 15:38
 **/
public interface IletterProcess {
    void writeLetter(String context);
    void sendLetter(String address);
}
