package com.adam.io.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-16 09:53
 **/
public class TCPServer {

    public void startServer() throws IOException {
        final  String  ip="127.0.0.1";
        ServerSocketChannel serverChannel=ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        //serverChannel.bind(new InetSocketAddress(ip, 10001));
        serverChannel.socket().bind(new InetSocketAddress(ip, 10001));
        System.out.println("TCP Server started!");
        Selector selector=Selector.open();
        SelectionKey key=serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        int i;
        while ((i=selector.select())>0){
            System.out.println("Selector return:" + i);
            Iterator<SelectionKey> it=selector.selectedKeys().iterator();
            System.out.println("selectedKeys number:" + selector.selectedKeys().size());
            while(it.hasNext()){
                SelectionKey selectionKey=it.next();
                if(selectionKey.isAcceptable()){
                    ServerSocketChannel serverChannel1=(ServerSocketChannel) selectionKey.channel();
                    System.out.println("SelectionKey is acceptable");
                    if(serverChannel ==null) continue;
                    //SocketChannel socketChannel=serverChannel.accept();
                    SocketChannel socketChannel=serverChannel1.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }else if(selectionKey.isReadable()){
                    //System.out.println("SelectionKey is readable");
                    SocketChannel socketChannel=(SocketChannel)selectionKey.channel();
                    ByteBuffer bf=ByteBuffer.allocate(1024);
                    int len;
                    while((len=socketChannel.read(bf))>0){
                        //bf.flip();
                        System.out.println("Received data: "+new String(bf.array(),0,len));
                        bf.clear();
                    }
                    socketChannel.close();
                }
            }
            it.remove();
        }
        selector.close();
        serverChannel.close();
    }
    public static void main(String[] args) throws IOException {
        TCPServer server=new TCPServer();
        server.startServer();
    }
}
