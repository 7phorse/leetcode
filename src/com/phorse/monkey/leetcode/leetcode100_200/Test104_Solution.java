package com.phorse.monkey.leetcode.leetcode100_200;

import com.phorse.monkey.leetcode.data.TreeNode;

/**
 * @author luoxusheng 2020/8/7 13:56
 * @version 1.0.0
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 */
public class Test104_Solution {

    /**
     * 思路：基础递归算法
     * 1. 定义递归终止条件， 当root==null时，递归结束
     * 2. 分别计算左右子树的最大深度
     * 3. 取最大值，加上当前根节点（+1）为最大深度
     *
     * @author luoxusheng 2021/2/27 13:58
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNum = maxDepth(root.left);
        int rightNum = maxDepth(root.right);
        return Math.max(leftNum, rightNum) + 1;
    }

    /**
     * 思路：基础递归算法，将深度index作为变量向下传递
     *
     * @author luoxusheng 2020/8/7 13:56
     */
    public int maxDepth1(TreeNode root) {
        return maxDepth(0, root);
    }

    public int maxDepth(int index, TreeNode root){
        if (root==null){
            return index;
        }
        if (root.left == null && root.right == null){
            return index + 1;
        }
        if (root.left == null){
            return maxDepth(index + 1, root.right);
        }
        if (root.right == null){
            return maxDepth(index + 1, root.left);
        }
        return Math.max(maxDepth(index + 1, root.right), maxDepth(index + 1, root.left));
    }
}
