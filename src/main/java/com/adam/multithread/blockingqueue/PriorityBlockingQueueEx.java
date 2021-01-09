package com.adam.multithread.blockingqueue;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-08 09:32
 **/
public class PriorityBlockingQueueEx {

    private static class User implements Comparable<User>{
        public String user;
        public int age;
        public User(String user, int age){
            this.user = user;
            this.age =age;
        }

        @Override
        public int compareTo(User o) {
            return this.age>o.age?1:this.age<o.age?-1:0;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<User> q = new PriorityBlockingQueue<>();
        for(int i=0; i<6; i++){
            if(i == 5) {
                User user2 = new User("u5", 5);
                q.add(user2);
            }
            User user = new User(String.format("user%d", i), i);
            q.add(user);
        }
        while(q.peek()!=null){
            User u = q.poll();
            System.out.println(u.user + " " + u.age);
        }
    }
}
