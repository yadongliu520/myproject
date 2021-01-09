package com.adam.netty;

import io.netty.util.Recycler;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-27 17:02
 **/
public class RecycleDemo {
    private static final Recycler<User> recycler =new Recycler<User>(){
        @Override
        public User newObject(Recycler.Handle<User> handle){
            return new User(handle);
        }
    };


    private static  class User{
        private final Recycler.Handle<User> handle;
        public User(Recycler.Handle<User> handle){
            this.handle=handle;
        }
        public void recycle(){
            this.handle.recycle(this);
        }
    }

    public static void main(String[] args) {
        User user1=recycler.get();
        User user3=recycler.get();
        user1.recycle();
        user3.recycle();

        User user2=recycler.get();
        System.out.println(user1==user2);// true
        System.out.println(user3==user2);// false只会缓存最近的对象？
    }
}
