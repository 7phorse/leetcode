package com.luo.leetcode.leetcode1_100;

import com.luo.leetcode.data.ListNode;

/**
 * @author luoxusheng 2021/1/3 12:22
 * @version 1.0.0
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 *
 */
public class Test86_Solution {
    public ListNode partition(ListNode head, int x) {
       ListNode leftHead = new ListNode(0);
       ListNode rightHead = new ListNode(0);
       ListNode left = leftHead;
       ListNode right = rightHead;
       while (head!=null){
           if(head.val < x){
               left.next = head;
               left = left.next;
           }else {
               right.next = head;
               right = right.next;
           }
           head = head.next;
       }
       left.next = rightHead.next;
       right.next = null;
       return leftHead.next;
    }
}
