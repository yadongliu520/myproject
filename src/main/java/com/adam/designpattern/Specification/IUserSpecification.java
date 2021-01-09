package com.adam.designpattern.Specification;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-04 09:00
 **/
public interface IUserSpecification {
    boolean isSatisfiedBy(User user);
    default IUserSpecification and(IUserSpecification spec){return null;};
    default IUserSpecification or(IUserSpecification spec){return null;};
    default IUserSpecification not(){return null;};

}
