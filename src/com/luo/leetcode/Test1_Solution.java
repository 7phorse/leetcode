package com.luo.leetcode;

import com.luo.leetcode.data.ListNode;

public class Test1_Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            //处理进位问题
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        ListNode l2=new ListNode(4);
        ListNode l3=new ListNode(3);
        l1.next=l2;
        l2.next=l3;

        ListNode l4=new ListNode(5);
        ListNode l5=new ListNode(6);
        ListNode l6=new ListNode(4);
        l4.next=l5;
        l5.next=l6;
        ListNode l7= addTwoNumbers(l1,l4);
        while(l7!=null){
            System.out.println(l7.val);
            l7=l7.next;
        }
    }

}
