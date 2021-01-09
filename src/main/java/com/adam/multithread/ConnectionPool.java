package com.adam.multithread;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-03 15:38
 **/
public class ConnectionPool {
    public static class ConnectionDriver{
        static class ConnectionHandler implements InvocationHandler{
            @Override
            public Object invoke(Object o, Method m, Object[] args){
                if(m.getName().equals("commit")){
                    ThreadState.SleepUtils.second(1);
                }
                return null;
            }
        }

        public static final Connection createConnection(){
            return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class[] {Connection.class}, new ConnectionHandler());

        }
    }
    private static  LinkedList<Connection> pool = new LinkedList<>();
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;
    static ConnectionPool conPool = new ConnectionPool(10);
    static AtomicInteger got = new AtomicInteger();
    static AtomicInteger notGot = new AtomicInteger();

    public ConnectionPool(int initSize){
        if(initSize>0){
            for(int i=0; i<initSize; i++){
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection){
        if(connection !=null){
            synchronized(pool){
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }
    public  Connection featchConnection(long mills) throws InterruptedException{
        synchronized(pool){
            if(mills<0){
                if(pool.isEmpty()) pool.wait();
                return pool.removeFirst();
            }else{
                long future = System.currentTimeMillis() +mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining>0){
                    pool.wait(remaining);
                    remaining = future -System.currentTimeMillis() ;
                }
                Connection res = null;
                if(!pool.isEmpty()){
                    res = pool.removeFirst();
                }
                return res;
            }
        }

    }


    public static class ConnectionRunner implements Runnable  {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot){
            this.count=count;
            this.got=got;
            this.notGot=notGot;
        }
        @Override
        public  void run() {
            try{
                start.await();
            }catch (Exception e){

            }
            while (count >0){
                try{
                    Connection connection = conPool.featchConnection(1);
                    if(connection !=null){
                        try{
                            connection.createStatement();
                            connection.commit();
                        }finally {
                            conPool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else{
                        notGot.incrementAndGet();
                    }
                }catch(Exception e){

                }finally {
                    count--;
                }
            }
            end.countDown();
        }
    }

    public static void main(String[] args) throws  InterruptedException{
         int threadCount = 10;
         end = new CountDownLatch(threadCount);
         int count=20;

         for(int i=0; i<threadCount; i++){
             Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionThread " + i);
             thread.start();
         }
         start.countDown();
         end.await();
        System.out.println("Total invoke: " + (threadCount*count));
        System.out.println("Got connections: " + got);
        System.out.println("Not got connections: " + notGot);

    }
}
