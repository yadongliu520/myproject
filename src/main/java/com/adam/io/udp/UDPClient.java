package com.adam.io.udp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-14 17:12
 **/
public class UDPClient {
    public void sendFile2() throws IOException{
        DatagramChannel channel=DatagramChannel.open();
        channel.configureBlocking(false);
        ByteBuffer bf=ByteBuffer.allocate(1023);
        bf.put("".getBytes());
        bf.flip();
        channel.send(bf, new InetSocketAddress("ip", 0));
    }

    public void sendFile() throws IOException {
        int[] ports={10001,10002};
        DatagramChannel udpChannel= DatagramChannel.open();
        ByteBuffer bf = ByteBuffer.allocate(1024);
        udpChannel.configureBlocking(false);
        Scanner scanner =new Scanner(System.in);
        System.out.println("UDP client启动成功。");
        System.out.println("请输入字符：");
        while (scanner.hasNextLine()){
            String inputRecord=scanner.nextLine();
            String data=String.format("[%s]输出记录：%s",
                    new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss").format(new Date()), inputRecord);
            bf.put(data.getBytes());
            bf.flip();
            double random=Math.random()*2;
            udpChannel.send(bf,new InetSocketAddress( "127.0.0.1", ports[(int)random]));
            System.out.println("Remote port is:"+ports[(int)random]);
            bf.clear();
        }
        udpChannel.close();
    }

    public static void main(String[] args) throws IOException {
        UDPClient client = new UDPClient();
        client.sendFile();
    }

}
