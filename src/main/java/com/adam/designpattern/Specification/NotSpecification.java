package com.adam.designpattern.Specification;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-04 09:42
 **/
public class NotSpecification extends CompositeSpecification {
    private IUserSpecification spec;
    public NotSpecification(IUserSpecification spec){
        this.spec=spec;
    }

    @Override
    public boolean isSatisfiedBy(User user){
        return !spec.isSatisfiedBy(user);
    }
}
