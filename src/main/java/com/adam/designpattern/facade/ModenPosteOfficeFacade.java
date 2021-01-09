package com.adam.designpattern.facade;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-11 15:42
 **/
public class ModenPosteOfficeFacade {
    private IletterProcess process=new LetterProcess();
    private Police police=new Police();
    public void sendLetter(String context, String address){
        process.writeLetter(context);
        police.checkLetter(process);
        process.sendLetter(address);
    }
}
