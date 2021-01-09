package com.adam.designpattern.vistor;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-28 00:00
 **/
public interface IVistor {
    void visit(CommonEmployee commonEmployee);
    void visit(Manager manager);
    default  void calTotalSalary(Employee employee){};
    default int getToTalSalary(){return 0;};
}
