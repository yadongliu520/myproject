package com.adam.basic.emptyinterface.serialize;

import java.io.*;

/**
 * @Description: 测试static类型变量不能序列化
 * @Author: Adam
 * @Date: 2021-10-29 15:19
 **/
public class TestStaticSerilize {
    static class User implements Serializable {
        private static final long serialVersionUID = 8294180014912103005L;

        static String username;
        private transient String passwd;
        //counter静态变量未序列化存入磁盘持久化，因此不能也不能反序列化
        private static int counter;

        public User(){

        }
        public User(String username, String passwd){
            this.username=username;
            this.passwd=passwd;
            ++counter;
        }
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPasswd() {
            return passwd;
        }

        public void setPasswd(String passwd) {
            this.passwd = passwd;
        }

        public String toString() {

            return "人数：" + counter + " 姓名：" + username + " 密码：" + passwd;
        }
    }

    public static void main(String[] args) {
        User user1=new User();
        User user2=new User();

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(
                    "/Users/adamliu/data/files/user.txt"));
            System.out.println("\nread after Serializable: ");
            System.out.println(user1);
            System.out.println(user2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
