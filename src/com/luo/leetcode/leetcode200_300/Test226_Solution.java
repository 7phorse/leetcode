package com.luo.leetcode.leetcode200_300;

import com.luo.leetcode.data.TreeNode;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @author luoxusheng 2020/9/16 13:40
 * @version 1.0.0
 */
public class Test226_Solution {

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        swap(root, root.left, root.right);
        return root;
    }

    private void swap(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) {
            return;
        }
        root.left = right;
        root.right = left;
        if (left != null) {
            swap(left, left.left, left.right);
        }
        if (right != null) {
            swap(right, right.left, right.right);
        }
    }

}
