package com.adam.io;

import sun.nio.ch.DirectBuffer;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-12 15:25
 **/
public class ZeroCopyEx {
    static void zeroCopy(String srcFile, String dstFile) throws IOException {
        FileChannel fcIn=null;
        FileChannel fcOut=null;
        try{
            fcIn=new FileInputStream(new File(srcFile)).getChannel();//使用new File方式也可以
            fcOut=new FileOutputStream(dstFile).getChannel();
            fcIn.transferTo(0, fcIn.size(), fcOut);
        }catch (Exception e){

        }finally {
            if(fcIn !=null) fcIn.close();
            if(fcOut !=null) fcOut.close();
        }
    }
    /*
    字节流方式copy
     */
    static void nonZeroCopy(String srcFile, String dstFile) throws IOException {
        InputStream inStream=null;
        OutputStream outStream=null;
        try{
            inStream=new BufferedInputStream(new FileInputStream(srcFile));
            outStream=new BufferedOutputStream(new FileOutputStream(dstFile));
            byte[] bytes= new byte[1024];
            int i;
            while ((i =inStream.read(bytes)) !=-1){
                outStream.write(bytes,0, i);
            }
        }catch (Exception e){}
        finally {
                if(inStream!=null)inStream.close();
                if(outStream!=null)outStream.close();
        }

    }
    public static void main(String[] args) throws IOException {
        String srcFile="/Users/adamliu/java_tmp/io_files/data1";
        String dstFile="/Users/adamliu/java_tmp/io_files/data2";
        String dstFile1="/Users/adamliu/java_tmp/io_files/data3";
        zeroCopy(srcFile,dstFile);
        nonZeroCopy(srcFile,dstFile1);
    }
}
