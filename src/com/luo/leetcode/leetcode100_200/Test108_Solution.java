package com.luo.leetcode.leetcode100_200;

import com.luo.leetcode.data.TreeNode;

/**
 * @author luoxusheng 2020/8/8 14:24
 * @version 1.0.0
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class Test108_Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    TreeNode sort(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(arr[mid]);
        treeNode.left = sort(arr, left, mid);
        treeNode.right = sort(arr, mid, right);
        return treeNode;
    }

}
