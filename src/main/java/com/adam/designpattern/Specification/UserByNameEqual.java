package com.adam.designpattern.Specification;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-04 09:02
 **/
public class UserByNameEqual extends CompositeSpecification implements IUserSpecification {
    private String name;
    public UserByNameEqual(String name){
        this.name=name;
    }
    @Override
    public boolean isSatisfiedBy(User user) {
         return user.getName().equals(name);
    }
}
