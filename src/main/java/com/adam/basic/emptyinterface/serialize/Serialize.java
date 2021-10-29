package com.adam.basic.emptyinterface.serialize;

import java.io.*;

/**
 * @Description: 1、 transient不能序列化；2、static不能序列化。
 * 参考链接：https://www.cnblogs.com/lanxuezaipiao/p/3369962.html
 * https://www.php.cn/java-article-418199.html
 * @Author: Adam
 * @Date: 2021-10-29 14:12
 **/
public class Serialize {
    static class User implements Serializable {
        private static final long serialVersionUID = 8294180014912103005L;

        private String username;
        /**
         * 反序列化后输出值为null。transient变量有效范围只在进程内存，默认不能通过夸节点网络传输或持久化到内存。如果真要序列化，需要实现
         * Externalizable接口。Serializable接口默认可序列化，而Externalizable需要指定可序列化的变量
         * 打个比方，如果一个用户有一些敏感信息（如密码，银行卡号等），为了安全起见，不希望在网络操作，不允许序列化
         */

        private transient String passwd;
        /**
         * counter静态变量，实例化多次，counter将连续累加。静态变量被同一个类不同实例共享，实际是jvm中的数值累加，并非能序列化。参见${TestStaticSerilize}
         */

        private static int counter=1;

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

        User user = new User();
        User user1=new User("liu","1");
        User user2=new User("wang","2");

        user.setUsername("Alexia");
        user.setPasswd("123456");

        System.out.println("read before Serializable: ");
        System.out.println("username: " + user.getUsername());
        System.err.println("password: " + user.getPasswd());

        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("/Users/adamliu/data/files/user.txt"));
            os.writeObject(user); // 将User对象写进文件
            os.writeObject(user1);
            os.writeObject(user2);
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(
                    "/Users/adamliu/data/files/user.txt"));
            user = (User) is.readObject(); // 从流中读取User的数据
            user1=(User)is.readObject();
            user2=(User)is.readObject();

            is.close();

            System.out.println("\nread after Serializable: ");
            System.out.println("username: " + user.getUsername());
            System.err.println("password: " + user.getPasswd());

            System.out.println(user1);
            System.out.println(user2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
