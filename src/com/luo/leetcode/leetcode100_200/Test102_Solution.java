package com.luo.leetcode.leetcode100_200;

import com.luo.leetcode.data.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author luoxusheng 2020/8/8 13:25
 * @version 1.0.0
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class Test102_Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            // 层数
            int n = queue.size();
            List<Integer> index = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode poll = queue.poll();
                index.add(poll.val);
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
            result.add(index);
        }
        return result;
    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<>();
//        if(root == null){
//            return result;
//        }
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            int n = queue.size();
//            List<Integer> index = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                TreeNode poll = queue.poll();
//                index.add(poll.val);
//                if(poll.left != null){
//                    queue.add(poll.left);
//                }
//                if(poll.right!= null){
//                    queue.add(poll.right);
//                }
//            }
//            result.add(index);
//        }
//        return result;
//    }
}
