package com.phorse.monkey.leetcode.leetcode1_100;

import com.phorse.monkey.leetcode.data.ListNode;

import java.util.Objects;

/**
 * @author luoxusheng 2020/8/4 13:47
 * @version 1.0.0
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Test93_Solution {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        node2.next = node3;
        head.next = node2;
        printNode(head);
        ListNode node = deleteDuplicates(head);
        printNode(node);

    }
    private static void printNode(ListNode head) {
        while (Objects.nonNull(head)) {
            System.out.print(head.val+"->");
            head = head.getNext();
        }
        System.out.println("");
    }

}
