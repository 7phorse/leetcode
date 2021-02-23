package com.luo.leetcode.leetcode1_100;

import com.luo.leetcode.data.ListNode;

/**
 * @Description: 合并两个有序链表
 * @Auther: luo
 * @Date: 2020/3/5 16:58
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 124
 * 134
 *
 * 1
 * 124
 * 34
 *
 * 1->1
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test21_Solution {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            System.out.println("l1:"+l1.val);
            System.out.println("l2:"+l2.val);
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            System.out.println("l1:"+l1.val);
            System.out.println("l2:"+l2.val);
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode b1 = new ListNode(4);
        l1.next = a1;
        a1.next = b1;

        ListNode l2 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        l2.next = a2;
        l2.next = b2;
        mergeTwoLists1(l1, l2).print();
    }

}
