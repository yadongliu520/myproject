package com.adam.designpattern.component;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-26 12:18
 **/
public class Client {
    public static void main(String[] args) {
        Branch branch=compositeCorpBranch();
        System.out.println(branch.getInfo());
        System.out.println(getTreeInfo(branch));
        Corp corp=getOneLeaf(branch);
        System.out.println("===\n");
        System.out.println(corp.getInfo());
        System.out.println("===\n");
        System.out.println(findParentList(corp));

    }
    public  static Branch  compositeCorpBranch(){
        Branch root=new Branch("zhangsan", 1000000, "ceo");
        Branch devDep=new Branch("Lisi", 800000, "dev Dep leader.");
        Branch productDep=new Branch("Wangwu", 600000, "productDep leader.");
        Branch saleDep=new Branch("Dingyi", 500000, "saleDep leader");
        Branch firstDevGroup=new Branch("Wangda", 400000, "firstDevGroup leader");
        Branch firstProductGroup=new Branch("qingli", 300000, "firstProductGroup leader");
        Branch firstSaleGroup=new Branch("Masi", 300000,"firstSaleGroup leader");
        Leaf developer1=new Leaf("Liyi",100000,"developer");
        Leaf developer2=new Leaf("Lier",100000,"developer");
        Leaf productDesigner1=new Leaf("Lisan",100000,"productDesigner");
        Leaf productDesigner2=new Leaf("Liwu",100000,"productDesigner");

        Leaf saler1=new Leaf("yangyi", 100000, "saler");
        Leaf saler2=new Leaf("yanger", 100000, "saler");
        //root.add(root);
        root.addSubordinate(devDep);
        root.addSubordinate(productDep);
//        root.addSubordinate(saleDep);
        devDep.addSubordinate(firstDevGroup);
        productDep.addSubordinate(firstProductGroup);
//        saleDep.addSubordinate(firstSaleGroup);

        firstDevGroup.addSubordinate(developer1);
        firstDevGroup.addSubordinate(developer2);

//        firstProductGroup.addSubordinate(productDesigner1);
//        firstProductGroup.addSubordinate(productDesigner2);
//
//        firstSaleGroup.addSubordinate(saler1);
//        firstSaleGroup.addSubordinate(saler2);

        return  root;
    }


    public static String getTreeInfo(Branch root){
        String treeInfo="";
        ArrayList<Corp> subordinate=root.getSubordinateList();
        for(Corp sub:subordinate){
            if(sub instanceof Leaf){
                treeInfo=treeInfo + sub.getInfo() + "\n";
            }else {
                treeInfo= treeInfo + sub.getInfo()+"\n"+ getTreeInfo((Branch)sub);
            }
        }
        return treeInfo;
    }

    public static String findParentList(Corp corp){
       String info="";
       if(corp.getParent()==null){
           info=info+corp.getInfo();
       }
       if(corp.getParent()!=null){
           info=info +corp.getInfo() + "\n" + findParentList(corp.getParent());
       }

       return info;
    }

    public static Corp getOneLeaf(Corp root){
        Corp corp=null;
        if(root instanceof Branch){
            ArrayList<Corp> arr=((Branch) root).getSubordinateList();
            if(arr.size()>0){
                corp=arr.get(0);
            }
            Corp corp2=getOneLeaf(corp);
            if(corp2!=null)
                corp=corp2;
        }
        return corp;
    }
}
