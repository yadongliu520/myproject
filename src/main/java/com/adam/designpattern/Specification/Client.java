package com.adam.designpattern.Specification;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-04 09:15
 **/
public class Client {
    public static void main(String[] args) {
        ArrayList<User> userList=new ArrayList<>();
        for(int i=0;i<5;i++){
            String name="N"+i;
            int age=i+3;
            userList.add(new User(name,age));
        }
        IUserProvider userProvider=new UserProvider(userList);
        System.out.println("Age large than 3:");
        IUserSpecification userSpec=new UserByAgeThan(3);
        for(User u :userProvider.findUser(userSpec)){
            System.out.println(u);
        }

        IUserSpecification spec2=new UserByNameEqual("N2");
        for(User u :userProvider.findUser(userSpec.and(spec2))){
            System.out.println("\n");
            System.out.println(u);
        }
    }
}
