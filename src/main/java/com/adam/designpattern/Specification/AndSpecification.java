package com.adam.designpattern.Specification;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-04 09:34
 **/
public class AndSpecification extends CompositeSpecification {
    private IUserSpecification left;
    private IUserSpecification right;
    public AndSpecification(IUserSpecification left, IUserSpecification right){
        this.left=left;
        this.right=right;
    }

    @Override
    public boolean isSatisfiedBy(User user){
        return left.isSatisfiedBy(user) && right.isSatisfiedBy(user);
    }
}
