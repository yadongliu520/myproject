package com.adam.alg.list;

//import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-20 21:04
 **/
public class ReverseList1 {
    static class Node {
        Object value;
        Node next;
    }

    public Node createLinkedList(Node head, Object[] arr){
        Node tail=head;
        Node track=head;
        for(Object o: arr){
            Node node=new Node();
            node.value=o;
            node.next=null;
            tail.next=node;
            tail=node;
        }

        return head;
    }
    //递归方式
    public Node reverseList2(Node head){
        if(head.next==null){
            return head;
        }
        Node rhead=reverseList2(head.next);
        if(head.next !=null){
            head.next.next=head;
        }
        head.next=null;
        return rhead;
    }

    public static Node reverseN(Node node) {
        Node end = null;
        while (node != null) {
            Node temp = node.next;
            node.next = end;
            end = node;
            node = temp;
        }
        return  end;
    }

    public Node reverseList3(Node head) {
        return recurMethod(head, null);
    }


    public static Node reverseList0(Node head) {
        Node pre = null;
        while (head != null) {
            Node temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }



    private Node recurMethod(Node cur, Node pre) {
        if (null == cur) return pre;    //递归终止条件
        Node reversedList = recurMethod(cur.next, cur);
        cur.next = pre;
        return reversedList;
    }



    public static Node reverseN1(Node head) {
        Node headNewTmp = null;
        while (null != head) {
            Node nodeTmp = new Node();
            nodeTmp.value = head.value;
            nodeTmp.next = headNewTmp;
            headNewTmp = nodeTmp;

            head = head.next;
        }

        head = headNewTmp;
        return head;
    }

    public Node reverseList(Node head){
        //头节点null，或单个节点情况
        if(head==null || head.next==null)return head;
        //两个节点情况
        if(head.next.next == null){
            Node tail=head;
            head=head.next;
            head.next=tail;
            tail.next=null;
            return head;
        }

        /*两个节点以上情况
        tail,track,head
        1->2->3 //start
        1<-2  3 //loop1
        1<-2  3->4 //head=head.next
        1<-2<-3  4 //track.next=back,back=track,track=head
         */
        Node tail=head;
        Node track=head.next;
        head=head.next;
        tail.next=null;
        Node back=tail;
        while (head.next!=null){
            head=head.next;
            track.next=back;
            back=track;
            track=head;
        }
        head.next=back;
        return head;
    }

    public static void main(String[] args) {
        ReverseList1 r=new ReverseList1();
        Node head= new Node();
        head.value=0;head.next=null;
        Integer[] arr= new Integer[]{1,2,3,4};
        Node list = r.createLinkedList(head, arr);
        head = r.reverseList0(head);
        System.out.println("list==head?" + (list == head));
        Node track=head;
        while (track !=null){
            System.out.println(track.value);
            track=track.next;
        }
    }
}
