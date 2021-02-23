package com.phorse.monkey.leetcode.leetcode1_100;

import com.phorse.monkey.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luoxusheng 2021/1/3 13:08
 * @version 1.0.0
 *
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 */
public class Test94_Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;

    }
    private void inorder(TreeNode root, List<Integer> result) {
        if(root == null){
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}
