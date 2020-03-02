package com.luo.leetcode.data;

public class ListNode {
    public ListNode next;
    public int val;

    public ListNode(int x) { val = x; }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void print(){
        ListNode node = this;
        while (node != null){
            System.out.print(node.val+"-->");
            node = node.next;
        }
        System.out.println("null");
    }
}
