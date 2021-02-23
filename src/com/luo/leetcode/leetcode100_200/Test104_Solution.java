package com.luo.leetcode.leetcode100_200;

import com.luo.leetcode.data.TreeNode;

/**
 * @author luoxusheng 2020/8/7 13:56
 * @version 1.0.0
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test104_Solution {

    public int maxDepth(TreeNode root) {
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
