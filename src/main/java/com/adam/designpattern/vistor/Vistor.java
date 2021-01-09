package com.adam.designpattern.vistor;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-28 00:02
 **/
public class Vistor implements IVistor {
    private final static int MANAGER_COEFFICIENT=1;
    private final static int COMMONEMPLOYEE_COEFFICIENT=1;

    private int totalCommonEmployeeSalary=0;
    private int totalManagerSalary=0;
    private int totalSalary=0;

    @Override
    public void visit(CommonEmployee commonEmployee) {
        System.out.println(this.getCommonEmpolyeeInfo(commonEmployee));
        this.calTotalSalary(commonEmployee);
    }

    @Override
    public void visit(Manager manager) {
        System.out.println(this.getManagerInfo(manager));
        this.calTotalSalary(manager);
    }


    private String getBasicInfo(Employee employee){
        return String.format("Name: %s;Sex: %d;Salary: %d.", employee.getName(), employee.getSex(), employee.getSalary());
    }

    private String getCommonEmpolyeeInfo(CommonEmployee employee){
        return getBasicInfo(employee) + employee.getOtherInfo();
    }

    private String getManagerInfo(Manager manager){
        return getBasicInfo(manager)+ manager.getOtherInfo();
    }

    private int calCommonSalary(Employee commonEmployee){
        this.totalCommonEmployeeSalary = this.totalCommonEmployeeSalary
                +commonEmployee.getSalary()*COMMONEMPLOYEE_COEFFICIENT;
        return this.totalCommonEmployeeSalary;
    }

    private int calManagerSalary(Employee manager){
        this.totalManagerSalary=this.totalManagerSalary+manager.getSalary()*MANAGER_COEFFICIENT;
        return this.totalManagerSalary;
    }

    @Override
    public void  calTotalSalary(Employee employee){
        if(employee instanceof CommonEmployee){
            this.totalSalary = this.totalSalary
                    +employee.getSalary()*COMMONEMPLOYEE_COEFFICIENT;
        }else if(employee instanceof Manager){
            this.totalSalary=this.totalSalary+employee.getSalary()*MANAGER_COEFFICIENT;
        }
    }
    @Override
    public int getToTalSalary() {
        //return this.totalManagerSalary+this.totalCommonEmployeeSalary;
        return this.totalSalary;
    }

}
