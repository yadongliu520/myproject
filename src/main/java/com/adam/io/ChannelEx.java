package com.adam.io;

import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-14 15:02
 **/
public class ChannelEx {
     static class SocketChannelClient   {
         public void sendFile2() throws Exception{
             FileChannel fileChannel=new FileInputStream("srcpath").getChannel();
             SocketChannel channel=SocketChannel.open();
             channel.configureBlocking(false);
             channel.socket().connect(new InetSocketAddress("ip", 111));
             ByteBuffer bf=ByteBuffer.allocate(1024);

             while(!channel.isConnected()){}
             channel.write(ByteBuffer.wrap("srcpath".getBytes()));//先写入文件名
             bf.putLong(new File("srcpath").length());//写入文件内容长度
             bf.flip();channel.write(bf);
             bf.clear();
             while(fileChannel.read(bf)>0){bf.flip();channel.write(bf);bf.clear();}

         }
        public void sendFile() throws Exception{
            String srcPath="/Users/adamliu/java_tmp/io_files/data1";
            String dstPath="/Users/adamliu/java_tmp/io_files/data2";
            FileChannel srcFc=new FileInputStream(srcPath).getChannel();;
            SocketChannel desSc= SocketChannel.open();
            SocketAddress socketAddress = new InetSocketAddress("127.0.0.1",10000);
            desSc.socket().connect(socketAddress);
            //设置SocketChannel通道为阻塞方式
            desSc.configureBlocking(false);
            //自旋直到socketChannel连接建立
            System.out.println("建立连接中。。。");
            while(!desSc.isConnected()){}
            //传输文件名
            ByteBuffer fileNameBf = Charset.forName("UTF-8").encode(dstPath);
            System.out.println("写入传输文件名。");
            desSc.write(fileNameBf);
            //传输长度及数据内容

            ByteBuffer dataBf =  ByteBuffer.allocate(1024) ;
            dataBf.putLong(new File(srcPath).length());
            dataBf.flip();
            System.out.println("写入传输文件内容长度。");
            desSc.write(dataBf);
            dataBf.clear();
            System.out.println("开始传输文件。");
            long len;
            while((len=srcFc.read(dataBf))>0){
                dataBf.flip();
                desSc.write(dataBf);
                dataBf.clear();//清空再次利用
            }
            if(len == -1){
               srcFc.close();
               desSc.close();
            }
            System.out.println("文件传输完成。");
        }
     }

    public static void main(String[] args) throws Exception {
        SocketChannelClient client =new SocketChannelClient();
        client.sendFile();
    }
}
