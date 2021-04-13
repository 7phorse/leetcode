package com.phorse.monkey.leetcode.leetcode700_800;

import com.phorse.monkey.leetcode.data.TreeNode;

import java.util.*;

/**
 * 给你一个二叉搜索树的根节点 root ，返回树中任意两不同节点值之间的最小差值 。
 *
 * @author luoxusheng 2021/4/13 13:25
 * @version v1.0.0
 */
public class Test783_Solution {

    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // DFS
        dfs(root, list);
        Collections.sort(list);
        int n = list.size();
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int cur = Math.abs(list.get(i) - list.get(i - 1));
            ans = Math.min(ans, cur);
        }
        return ans;
    }

    void dfs(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if (root.left != null) {
            dfs(root.left, list);
        }
        if (root.right != null) {
            dfs(root.right, list);
        }
    }

}
