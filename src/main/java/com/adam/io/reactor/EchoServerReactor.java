package com.adam.io.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;

class EchoServerReactor implements Runnable {
    private int counter;
    Selector selector;
    ServerSocketChannel serverChannel;
    public EchoServerReactor() throws IOException {
        selector=Selector.open();

        serverChannel=ServerSocketChannel.open();
        //serverChannel=SelectorProvider.provider().openServerSocketChannel();
        serverChannel.socket().bind(new InetSocketAddress("127.0.0.1", 10001));
        serverChannel.configureBlocking(false);
        SelectionKey key=serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        //SelectionKey key=serverChannel.register(selector, 0);
        //sk.interestOps(SelectionKey.OP_ACCEPT);
        key.attach(new AcceptorHandler());



        System.out.println("Server started!");
        System.out.println(key.channel() + ".key hashcode:"+ key.hashCode() +
                ". key string:" + key.toString());
    }

    void dispatch(SelectionKey key){
        Runnable handler=(Runnable)key.attachment();
        if(handler!=null)
            handler.run();
    }


    class AcceptorHandler implements Runnable{
        @Override
        public void run() {
            try {
                SocketChannel socketChannel=serverChannel.accept();

                System.out.println("Channel: " + socketChannel);
                if(socketChannel!=null){
                    new EchoHandler(selector, socketChannel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){

            try {
                System.out.println("Pre Select!");
                int channelNum=selector.select();//该方法会阻塞，直到有事件发生
                System.out.println("Channel num: " + channelNum);
                Iterator<SelectionKey> it=selector.selectedKeys().iterator();

                while (it.hasNext()){
                    counter++;
                    System.out.println("Counter:" + counter);
                    SelectionKey key=it.next();
                    System.out.println("Event operation:" +key.readyOps());
                    System.out.println(key.channel() + ".key hashcode:"+ key.hashCode() +
                            ". key string:" + key.toString());
                    dispatch(key);
                }
                selector.selectedKeys().clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        EchoServerReactor echoServerReactor=new EchoServerReactor();
        Thread t=new Thread(echoServerReactor);
        t.start();
    }
}