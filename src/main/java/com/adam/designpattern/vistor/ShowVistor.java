package com.adam.designpattern.vistor;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-28 22:58
 **/
public class ShowVistor implements IShowVistor {
    private String info;
    @Override
    public void reprort() {
        System.out.println(this.info);
    }

    @Override
    public void visit(CommonEmployee commonEmployee) {
        this.info=this.info+this.getCommonEmpolyeeInfo(commonEmployee)+"\t\n";
    }

    @Override
    public void visit(Manager manager) {
        this.info=this.info+this.getManagerInfo(manager)+"\t\n";
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


    @Override
    @Deprecated
    public void calTotalSalary(Employee employee) {

    }

    @Override
    @Deprecated
    public int getToTalSalary() {
        return 0;
    }
}
