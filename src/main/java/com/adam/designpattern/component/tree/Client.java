package com.adam.designpattern.component.tree;

import com.adam.designpattern.component.tree.Branch;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-10-06 08:59
 **/
public class Client {
    public static void main(String[] args) {
        Node root=createTree();
        System.out.println(root.getData());
        System.out.println(getTreeInfo(root));
        System.out.println(getTreeLeaf(root));
        System.out.println(outOffSpringOfNode(root));
        System.out.println(getOneLeaf(root).getData());
        System.out.println(outAncestorsOfNode(getOneLeaf(root)));
        System.out.println(getOneBranchNode(root).getData());
        System.out.println(outOffSpringOfNode(getOneBranchNode(root)));
    }

    public static Node createTree(){
        Branch root=new Branch("root");
        Branch branch21=new Branch("level2-1");
        Branch branch22=new Branch("level2-2");
        Branch branch31=new Branch("level3-1");
        Branch branch32=new Branch("level3-2");
        Leaf leaf211=new Leaf("level2-1-1");
        Leaf leaf212=new Leaf("level2-1-2");
        Leaf leaf311=new Leaf("level3-1-1");

        root.addChild(branch21);
        root.addChild(branch22);

        branch21.addChild(branch31);
        branch21.addChild(branch32);

        branch21.addChild(leaf211);
        branch21.addChild(leaf212);
        branch31.addChild(leaf311);

        return root;
    }
    public static String getTreeInfo(Node root){
        String treeInfo="";
        ArrayList<Node> children=((Branch)root).getChildren();
        for(Node child:children){
            if(child instanceof Leaf){
                treeInfo=treeInfo+child.getData() +"\n";
            }else {
                treeInfo=treeInfo+child.getData()+"\n"+getTreeInfo(child);
            }
        }
        return treeInfo;
    }

    public static String getTreeLeaf(Node root){
        String leafInfo="";
        if(root instanceof Leaf){
            leafInfo=root.getData() + "\n";
        }
        if(root instanceof Branch){
            ArrayList<Node> children=((Branch)root).getChildren();
            for(Node child:children){

                leafInfo=leafInfo  + getTreeLeaf(child);
            }
        }
        return leafInfo;
    }

    public static String outAncestorsOfNode(Node node){
        String ancestorsInfo="";
        if(node.getParent()==null){
            ancestorsInfo=ancestorsInfo+node.getData()+"\n";
        }else{

            ancestorsInfo=ancestorsInfo +node.getData()+"\n"+outAncestorsOfNode(node.getParent());
        }
        return ancestorsInfo;
    }

    public static String outOffSpringOfNode(Node node) {
        String offSpringsInfo="";
        if(node instanceof Branch) {
            ArrayList<Node> offSprings = ((Branch) node).getChildren();
            for (Node child : offSprings) {
                offSpringsInfo = offSpringsInfo + child.getData() + "\n" + outOffSpringOfNode(child);
            }
        }
        return offSpringsInfo;
    }

    public static Node getOneLeaf(Node root){
        Node leaf=null;
        if(root instanceof Branch){
            ArrayList<Node> children=((Branch)root).getChildren();
            for(Node child:children){
                if(children.size()>0){
                    if(child instanceof Leaf){
                        leaf=child;break;
                    }else{
                        if(getOneLeaf(child)!=null){
                            leaf=getOneLeaf(child);
                        }
                    }
                }
            }
        }
        return leaf;
    }

    public static Node getOneBranchNode(Node root){
        Node oneBranchNode=null;
        if(root instanceof Branch){
            ArrayList<Node> children=((Branch) root).getChildren();
            for(Node child:children){
                if(child instanceof Branch && ((Branch)child).getChildren().size()>0){
                    oneBranchNode=child;break;
                }
            }
        }
        return oneBranchNode;
    }
}
