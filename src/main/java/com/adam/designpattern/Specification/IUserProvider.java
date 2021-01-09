package com.adam.designpattern.Specification;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-04 08:58
 **/
public interface IUserProvider {
    public ArrayList<User> findUser(boolean condition);
    public ArrayList<User> findUser(IUserSpecification userSpecification);
}
