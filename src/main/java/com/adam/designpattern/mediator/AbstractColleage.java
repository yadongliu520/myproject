package com.adam.designpattern.mediator;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-23 08:21
 **/
public abstract class AbstractColleage {
        protected AbstractMediator mediator;
        public AbstractColleage(AbstractMediator mediator){
            this.mediator=mediator;
        }

}
