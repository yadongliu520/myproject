package com.adam.designpattern.callback;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-24 14:44
 **/
public class Client {
    Server server = new Server();
    public void sendMsgAsync(String msg){
        System.out.println("Pre to send msg asynchronously.");
        new Thread(()->{
            server.getAndProcesMsg(new MyCallBack(), msg);
            //server.callBack();
        }).start();
        System.out.println("Continue doing something.");
    }

    public void sendMsgSync(String msg){
        System.out.println("Pre to send msg synchronously");
        server.getAndProcesMsg(new MyCallBack(), msg);
        System.out.println("Continue doing something.");
        //server.callBack();
    }

    public class MyCallBack implements CallBack{
       @Override
       public void process(){
           System.out.println("Server has finished to receive and process msg.");
       }
    }

    public static void main(String[] args) {
        Client client=new Client();
        //client.sendMsgAsync("Do it!");//异步调用
        client.sendMsgSync("Do it!");//同步调用
    }
}
