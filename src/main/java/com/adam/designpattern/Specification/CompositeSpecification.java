package com.adam.designpattern.Specification;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-04 09:35
 **/
public class CompositeSpecification implements IUserSpecification{
    @Override
    public boolean isSatisfiedBy(User user) {
        return false;
    }

    @Override
    public IUserSpecification and(IUserSpecification spec) {
        return new AndSpecification(this,spec);
    }

    @Override
    public IUserSpecification or(IUserSpecification spec) {
        return new OrSpecification(this, spec);
    }

    @Override
    public IUserSpecification not() {
        return new NotSpecification(this);
    }
}
