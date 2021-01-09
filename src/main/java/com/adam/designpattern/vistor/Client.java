package com.adam.designpattern.vistor;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-28 00:10
 **/
public class Client {
    public static void main(String[] args) {
        IVistor vistor=new Vistor();
        IShowVistor showVistor=new ShowVistor();
        ITotalVistor totalVistor=new TotalVistor();
        for(Employee e:mockData()){
            //e.accept(vistor);
            e.accept(showVistor);
            e.accept(totalVistor);

        }
       // System.out.println("Total Salary:" + vistor.getToTalSalary());
        showVistor.reprort();
        totalVistor.totalSalary();

    }

    public static ArrayList<Employee> mockData(){
        ArrayList<Employee> arr=new ArrayList<>();
        for(int i=0;i<2;i++){
            Random random=new Random();
            int salaryNum=random.nextInt(100000) +100000;
            CommonEmployee commonEmployee=new CommonEmployee();
            commonEmployee.setJob("dev");
            commonEmployee.setName("zhang" +i);
            commonEmployee.setSalary(salaryNum);
            arr.add(commonEmployee);
        }
        Manager manager=new Manager();
        manager.setPerformance("B");
        manager.setName("Li4");
        manager.setSalary(200000);
        arr.add(manager);
        return arr;
    }
}
