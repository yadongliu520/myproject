package com.adam.designpattern.Specification;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-04 09:08
 **/
public class UserProvider implements IUserProvider {
    private ArrayList<User> userList;
    public UserProvider(ArrayList<User> userList){
        this.userList=userList;
    }
    @Override
    @Deprecated
    public ArrayList<User> findUser(boolean condition) {
        return null;
    }

    @Override
    public ArrayList<User> findUser(IUserSpecification userSpecification) {
        ArrayList<User> result=new ArrayList<>();
        for(User u:userList){
            if(userSpecification.isSatisfiedBy(u)){
                result.add(u);
            }
        }
        return result;
    }
}
