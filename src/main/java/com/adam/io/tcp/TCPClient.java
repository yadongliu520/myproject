package com.adam.io.tcp;

import com.adam.multithread.ThreadState;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-16 10:22
 **/
public class TCPClient {
    public void sendDataSystemIn(SocketChannel channel, String name) throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please input: ");
        while(scanner.hasNextLine()){
            String input=scanner.nextLine();
            channel.write(ByteBuffer.wrap(input.getBytes()));
        }
        channel.shutdownOutput();
        channel.close();
    }
    public void sendData(SocketChannel channel, String name) throws IOException {
        channel.write(ByteBuffer.wrap(String.format("%s sayed hello", name).getBytes()));
        channel.shutdownOutput();
        channel.close();
    }
    public SocketChannel startClient(int port,String name) throws IOException {
        final String ip="127.0.0.1";
        InetSocketAddress address=new InetSocketAddress(ip, port);
        SocketChannel channel=SocketChannel.open(address);
        channel.configureBlocking(false);
       //channel.connect(address);
        while(!channel.isConnected()){}
        System.out.println(channel + " has connected remote server!");
        return channel;
    }

    public static void main(String[] args) throws IOException {
        TCPClient client=new TCPClient();
       for(int i=0;i<3;i++){
           SocketChannel channel1=client.startClient(10001,String.format("Socket channel%d",i));
           client.sendData(channel1,String.format("Socket channel%d",i));
           //ThreadState.SleepUtils.second(3);
       }
    }
}
