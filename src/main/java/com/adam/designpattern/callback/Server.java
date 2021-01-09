package com.adam.designpattern.callback;

import com.adam.multithread.ThreadState;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-24 14:44
 **/
public class Server {
    public void callBack(){
        System.out.println("Server has finished to receive and process msg.");
    }

    public void getAndProcesMsg(CallBack callBack, String msg){
        System.out.println("Server has reveived msg and is processing msg");
        ThreadState.SleepUtils.second(1);
        callBack.process();
    }
}
