package com.adam.io.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

class EchoClient2 {
    Selector selector;
    SocketChannel channel;
    public void startClient() throws IOException {
        selector=Selector.open();
        channel=SocketChannel.open(new InetSocketAddress("127.0.0.1", 10001));
        channel.configureBlocking(false);
        while(!channel.isConnected()){}
        Thread t=new Thread(new Processor(selector, channel));
        t.start();
    }
    class Processor implements Runnable{
        final  Selector selector;
        final  SocketChannel channel;
        Processor(Selector selector,SocketChannel channel) throws ClosedChannelException {
            this.selector=selector;
            this.channel=channel;
            channel.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE);

        }
        @Override
        public void run(){
            while(!Thread.interrupted()){
                System.out.println("Out loop");
                try {
                    selector.select();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Iterator<SelectionKey> it=selector.selectedKeys().iterator();
                while (it.hasNext()){
                    SelectionKey key=it.next();
                    if(key.isWritable()){
                        Scanner scanner=new Scanner(System.in);
                        System.out.println("Please input:");
                        if(scanner.hasNextLine()){
                            String input=scanner.nextLine();
                            SocketChannel channel1=(SocketChannel)key.channel();//can also use this instead of channel
                            try {
                                String im=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +
                                        ". Sended im to server: " + input;
                                System.out.println(im);
                                channel.write(ByteBuffer.wrap(im.getBytes()));
                                channel.register(selector, SelectionKey.OP_READ);//need
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }else if(key.isReadable()){
                        ByteBuffer bf=ByteBuffer.allocate(1024);
                        SocketChannel channel1=(SocketChannel)key.channel();
                        int len=0;
                        try {
                            while (((len=channel1.read(bf))>0)){
                                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                                        + ". Recieved echo im from server: " + new String(bf.array(), 0, len));
                            }
                            channel1.register(selector, SelectionKey.OP_WRITE);//need
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    key.channel();
                }
                selector.selectedKeys().clear();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        EchoClient2 client=new EchoClient2();
        client.startClient();
    }
}