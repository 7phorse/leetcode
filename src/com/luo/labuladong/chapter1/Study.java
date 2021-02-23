package com.luo.labuladong.chapter1;

import com.luo.leetcode.data.ListNode;
import com.luo.leetcode.data.TreeNode;

/**
 * @author luoxusheng 2021/1/3 18:19
 * @version 1.0.0
 */
public class Study {

    /**
     * 数组遍历框架
     */
    void traverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 迭代方位arr[i]
        }
    }

    /**
     * 链表遍历框架-for循环迭代
     */
    void traverse_iter_for(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            // 迭代遍历p.val
        }
    }

    /**
     * 链表遍历框架-while循环迭代
     */
    void traverse_iter_while(ListNode head) {
        while (head.next != null) {
            // 迭代遍历head.val
            head = head.next;
        }
    }

    /**
     * 链表遍历框架-递归
     */
    void traverse_recursion(ListNode head) {
        // 前序遍历 head.val
        traverse_recursion(head.next);
        // 后序遍历 head.val
    }

    /**
     * 二叉树遍历框架
     */
    void traverse(TreeNode root){
        // 前序遍历
        traverse(root.left);
        // 中序遍历
        traverse(root.right);
        // 后序遍历
    }

}
