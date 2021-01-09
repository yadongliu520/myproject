package com.adam.designpattern.Specification;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-04 09:05
 **/
public class UserByAgeThan extends CompositeSpecification implements IUserSpecification {
    private int age;
    public UserByAgeThan(int age){
        this.age=age;
    }
    @Override
    public boolean isSatisfiedBy(User user) {
        return user.getAge()>age;
    }
}
