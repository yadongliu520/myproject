package com.adam.basic.emptyinterface;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-13 08:37
 **/
public class ClonableDemo implements Cloneable {
        private String str;

        public ClonableDemo()
        {
            System.out.println("Enter SimpleObject.constructor()");
        }

        public String getStr()
        {
            return str;
        }

        public void setStr(String str)
        {
            this.str = str;
        }

        public Object clone() throws CloneNotSupportedException
        {
            return super.clone();
        }
    public static void main(String[] args) throws Exception
    {
        ClonableDemo so0 = new ClonableDemo();
        so0.setStr("111");
        ClonableDemo so1 = (ClonableDemo)so0.clone();

        System.out.println("so0 == so1?" + (so0 == so1));
        System.out.println("so0.getClass() == so1.getClass()?" + (so0.getClass() == so1.getClass()));
        System.out.println("so0.equals(so1)?" + (so0.equals(so1)));

        so1.setStr("222");
        System.out.println("so0.getStr()：" + so0.getStr());
        System.out.println("so1.getStr()：" + so1.getStr());
    }
}
