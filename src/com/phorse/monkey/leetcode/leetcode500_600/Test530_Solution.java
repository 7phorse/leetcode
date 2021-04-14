package com.phorse.monkey.leetcode.leetcode500_600;

import com.phorse.monkey.leetcode.data.TreeNode;
import com.phorse.monkey.utils.TreeUtils;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * @author luoxusheng 2021/4/13 19:46
 * @version v1.0.0
 */
public class Test530_Solution {

    private static int min = Integer.MAX_VALUE;
    private static TreeNode preNode;

    public static int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    private static void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        if(preNode != null){
            min = Math.min(min, Math.abs(preNode.val - root.val));
        }
        preNode = root;
        dfs(root.right);
    }

}
