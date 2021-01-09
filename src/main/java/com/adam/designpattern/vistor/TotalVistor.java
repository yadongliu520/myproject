package com.adam.designpattern.vistor;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-28 23:06
 **/
public class TotalVistor implements ITotalVistor {
    private final static int MANAGER_COEFFICIENT=1;
    private final static int COMMONEMPLOYEE_COEFFICIENT=1;

    private int totalCommonEmployeeSalary=0;
    private int totalManagerSalary=0;
    private int totalSalary=0;
    @Override
    public void totalSalary() {
        this.totalSalary=this.totalManagerSalary+this.totalCommonEmployeeSalary;
        System.out.println("Total salary: " + totalSalary);
    }

    @Override
    public void visit(CommonEmployee commonEmployee) {
        this.totalCommonEmployeeSalary = this.totalCommonEmployeeSalary
                +commonEmployee.getSalary()*COMMONEMPLOYEE_COEFFICIENT;
    }

    @Override
    public void visit(Manager manager) {
        this.totalManagerSalary=this.totalManagerSalary+manager.getSalary()*MANAGER_COEFFICIENT;
    }


}
