package com.luo.leetcode.test;

import com.luo.leetcode.data.ListNode;

import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @Auther: luo
 * @Date: 2018/11/3 11:40
 */
public class Solution_tmp {

    /**
     * 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     * @param head head
     * @return ListNode
     */
    public static ListNode reverseList_digui(ListNode head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.next == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接还回
        }
        ListNode reHead = reverseList_digui(head.next);// 先反转后续节点head.getNext()
        head.next.next = head;// 将当前结点的指针域指向前一结点
        head.next = null;// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }

    public static ListNode reverseList_forEach(ListNode head) {
        if (head == null)
            return head;
        ListNode pre = head;// 上一结点
        ListNode cur = head.getNext();// 当前结点
        ListNode tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur != null) {// 当前结点为null，说明位于尾结点
            tmp = cur.getNext();
            cur.setNext(pre);// 反转指针域的指向

            // 指针往下移动
            pre = cur;
            cur = tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.setNext(null);

        return pre;
    }

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 示例:
     * <p>
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     * 说明:
     * <p>
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * @param head head
     * @return ListNode
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = temp.next;
        temp.next = head;
        head.next = swapPairs(head.next);
        return temp;
    }

    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static ListNode detectCycle(ListNode head) {
        if( head == null || head.next == null ){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if( fast == slow ){  //说明有环
                break;
            }
        }
        if( fast == null || fast.next == null ){
            return null;
        }

        slow = head;
        while( fast != slow ){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

//        System.out.println(hasCycle(node1));
        System.out.println("原始:");
        printNode(node1);
        swapPairs(node1);
        System.out.println("排序后");
        printNode(node2);
    }

    private static void printNode(ListNode head) {
        while (Objects.nonNull(head)) {
            System.out.print(head.val);
            head = head.getNext();
        }
        System.out.println("");
    }
}
