package com.adam.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-11 12:04
 **/
public class ByteBufferEx {
    public static void writeToBuffer(ByteBuffer bf, FileChannel fc) throws IOException {
        System.out.println("Buffer position:"+bf.position()+";Buffer capacity:"+bf.capacity()+";Buffer limit:"+bf.limit());
        fc.read(bf);
        bf.flip();
        while(bf.hasRemaining()){
            System.out.println((char)bf.get());
            System.out.println("Buffer position:"+bf.position()+";Buffer capacity:"+bf.capacity()+";Buffer limit:"+bf.limit());
        }

        //fc.write(ByteBuffer.wrap("6".getBytes()));
    }

    public static void readFromBuffer(ByteBuffer bf,FileChannel fc) throws IOException {
        fc.write(ByteBuffer.wrap("123".getBytes()));
        fc.write(ByteBuffer.wrap("45".getBytes()));
        System.out.println("FileChannel size:"+fc.size()+"File ChannelEx position:"+fc.position());
        writeToBuffer(bf, fc.position(3));
    }

    public static void main(String[] args) throws IOException {
        FileChannel fc0=new FileOutputStream("/Users/adamliu/java_tmp/io_files/data1").getChannel();
        FileChannel fc1=new FileInputStream("/Users/adamliu/java_tmp/io_files/data1").getChannel();
        FileChannel fc2=new RandomAccessFile("/Users/adamliu/java_tmp/io_files/data1", "rw").getChannel();
        ByteBuffer bf = ByteBuffer.allocate(1024);
        readFromBuffer(bf,fc2);//fc1和fc2等价
        //writeToBuffer(bf, fc1);
        bf.rewind();
        readFromBuffer(bf,fc2);
        fc1.close();
        fc2.close();
        fc0.close();
    }
}
