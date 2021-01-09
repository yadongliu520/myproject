package com.adam.designpattern.Specification;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-04 09:40
 **/
public class OrSpecification extends CompositeSpecification {
    private IUserSpecification left;
    private IUserSpecification right;
    public OrSpecification(IUserSpecification left, IUserSpecification right){
        this.left=left;this.right=right;
    }

    @Override
    public boolean isSatisfiedBy(User user){
        return left.isSatisfiedBy(user) || right.isSatisfiedBy(user);
    }
}
