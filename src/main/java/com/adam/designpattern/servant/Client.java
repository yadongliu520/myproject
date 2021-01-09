package com.adam.designpattern.servant;

/**
 * @Description: Extendent of command pattern.
 * @Author: Adam
 * @Date: 2020-10-05 08:40
 **/
public class Client {
    public static void main(String[] args) {
        Cleaner cookie =new Cleaner();
        cookie.clean(new Kitchen());
        Cleaner gardener=new Cleaner();
        gardener.clean(new Garden());
        Cleaner tailer=new Cleaner();
        tailer.clean(new Cloth());
    }
}
