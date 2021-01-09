package com.adam.multithread.blockingqueue;

import com.adam.multithread.ThreadState;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-10 19:48
 **/
public class AutoRecycleOrder {
    static class Order implements Delayed{
        long orderId;
        long expireTime=2000;
        long orderCreateTime;
        public Order(long orderCreateTime, long orderId){
            this.orderCreateTime=orderCreateTime;
            this.orderId=orderId;
        }
        @Override
        public long getDelay(TimeUnit unit) {
            return System.currentTimeMillis()-orderCreateTime;
        }

        @Override
        public int compareTo(Delayed o) {
            Order order = (Order)o;
            return this.orderCreateTime<((Order) o).orderCreateTime?1:-1;
        }
    }

    static class OrderExpireCleaner implements  Runnable{
        DelayQueue<Order> q;
        public OrderExpireCleaner(DelayQueue q){
            this.q=q;
        }
        public void init(Thread t){
            t.setDaemon(true);
            t.start();
        }

        @Override
        public void run() {
            try{
                while(true){
                    Order order=q.take();
                    System.out.println("Clean an order and order id is "+ order.orderId);
                    ThreadState.SleepUtils.second(1);
                }
            }catch (Exception e){}
        }
    }

    static class OrderTask implements Runnable{
        DelayQueue<Order> q;
        AtomicLong orderId=new AtomicLong(0);
        public OrderTask(DelayQueue q){
            this.q=q;
        }

        public void addOrder(Order order){
            q.put(order);
        }

        @Override
        public void run(){
            while (true){
                long orderCreateTime=System.currentTimeMillis();
                long id=orderId.getAndIncrement();
                Order order =new Order(orderCreateTime, id);
                addOrder(order);
                System.out.println("Order id as created:  " + id);
                ThreadState.SleepUtils.second(1);
            }
        }
    }

    public static void main(String[] args) {
        DelayQueue<Order> q=new DelayQueue();
        OrderExpireCleaner cleaner =new OrderExpireCleaner(q);
        cleaner.init(new Thread(cleaner));
        OrderTask ot = new OrderTask(q);
        Thread orderOp1 = new Thread(ot);
        Thread orderOp2 = new Thread(ot);
        Thread orderOp3 = new Thread(ot);
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(orderOp1);
        service.execute(orderOp2);
        service.execute(orderOp3);
    }
}
