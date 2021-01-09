package com.adam.io.reactor;

import com.adam.multithread.ThreadState;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

class EchoHandler implements Runnable{
    SelectionKey key;
    SocketChannel channel;
    ByteBuffer bf=ByteBuffer.allocate(1024);
    final  int RECEVING=0;
    final int SENDING=1;
    int state=RECEVING;
    EchoHandler(Selector selector, SocketChannel Channel) throws IOException {
        this.channel=Channel;
        this.channel.configureBlocking(false);
        key=this.channel.register(selector, 0);
        key.interestOps(SelectionKey.OP_READ);
        key.attach(this);
        //selector.wakeup();
        System.out.println("Initiate EchoHandler!");
    }

    @Override
    public void run() {
        //System.out.println("state value: "+ state);
            if(state==SENDING){
                //System.out.println("Sending？");
                try {
                    //SocketChannel channel=(SocketChannel) key.channel();
                    channel.write(bf);
                    System.out.println("Sending " + new String(bf.array(),0,bf.limit()));
                    System.out.println("Channel connection status: "+ channel.isConnected());
                    bf.clear();
                    key.interestOps(SelectionKey.OP_READ);
                    state=RECEVING;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(state==RECEVING){
                int len=0;
                try {
                    if((len=channel.read(bf))>0){
                        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +
                                ". Received data: " + new String(bf.array(),0,len));
                    }

                    bf.flip();
                    key.interestOps(SelectionKey.OP_WRITE);
                    state=SENDING;
                    System.out.println("Channel connection status: "+ channel.isConnected());
                    System.out.println("Pre to send!");
                    //ThreadState.SleepUtils.second(5);


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}