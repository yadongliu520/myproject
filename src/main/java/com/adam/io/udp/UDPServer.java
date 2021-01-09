package com.adam.io.udp;

import com.adam.multithread.ThreadState;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-14 17:32
 **/
public class UDPServer {
    public void recieve1() throws IOException{
       DatagramChannel channel=DatagramChannel.open();
       channel.configureBlocking(false);
       channel.bind(new InetSocketAddress("ip", 10000));
       Selector selector=Selector.open();
       channel.register(selector, SelectionKey.OP_READ);
       while(selector.select()>=0){
            Iterator<SelectionKey> it=selector.selectedKeys().iterator();
            ByteBuffer bf=ByteBuffer.allocate(1024);
            while(it.hasNext()){
                SelectionKey selectionKey=it.next();
                if(selectionKey.isReadable()){
                    channel.receive(bf);
                    bf.flip();
                    System.out.println("");
                    bf.clear();
                }
            }
       }
       channel.close();
       selector.close();
    }



    public void outPut(DatagramChannel channel,Selector selector, String channelName) throws IOException {
        while(selector.select()>0){
            ThreadState.SleepUtils.second(1);
            Iterator<SelectionKey> it =selector.selectedKeys().iterator();
            ByteBuffer bf=ByteBuffer.allocate(1024);
            while(it.hasNext()){
                //System.out.println("Iterator size>=1");
                SelectionKey selectionKey =it.next();
                DatagramChannel channel1=(DatagramChannel)selectionKey.channel();
                if(selectionKey.isReadable()){
                    channel1.receive(bf);
                    bf.flip();
                    if(bf.limit()!=0)
                        System.out.println(channelName + " Received data: " + new String(bf.array(), 0, bf.limit()));
                    bf.clear();
                }
            }
            it.remove();
        }
    }

    public DatagramChannel newChannel(String ip, int port, String channelName) throws IOException {
        DatagramChannel channel=DatagramChannel.open();
        channel.configureBlocking(false);
        channel.bind(new InetSocketAddress(ip, port));
        System.out.println(String.format("UDP Server %s started.", channelName));
        return channel;
    }
    public void recieve() throws IOException {
        String ip="127.0.0.1";
        DatagramChannel channel1=newChannel(ip, 10001, "channel1");
        DatagramChannel channel2=newChannel(ip,10002, "channel2");

        Selector selector=Selector.open();
        channel1.register(selector, SelectionKey.OP_READ);
        channel2.register(selector, SelectionKey.OP_READ);

        outPut(channel1,selector,"channel1");
        //outPut(channel2,selector,"channel2");

       new Thread(()-> {
            try {
                outPut(channel1,selector,"channel1");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();


//        selector.close();
//        channel1.close();
//        channel2.close();
    }

    public static void main(String[] args) throws IOException {
        UDPServer server=new UDPServer();
        server.recieve();
    }
}
