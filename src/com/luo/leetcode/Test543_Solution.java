package com.luo.leetcode;

import com.luo.leetcode.data.TreeNode;

/**
 * @Description: 二叉树的直径
 * @Auther: luo
 * @Date: 2020/3/10 23:07
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test543_Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.getLeft());
        int right = depth(node.getRight());
        //将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        max = Math.max(left + right, max);
        //返回节点深度
        return Math.max(left, right) + 1;

    }

}
