package com.phorse.monkey.leetcode.leetcode1_100;

/**
 * 给定一个整数 n，求以1...n为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * @author luoxusheng 2021/2/23 23:30
 * @version v1.0.0
 */
public class Test96_Solution {

    /**
     * 思路：如果整数 1 - n 中的 k 作为根节点值，则 1 - k-1 会去构建左子树，k+1 - n 会去构建右子树。
     * 左子树出来的形态有 a 种，右子树出来的形态有 b 种，则整个树的形态有 a * b种。
     *  · 以 k 为根节点的 BST 种类数 = 左子树 BST 种类数 * 右子树 BST 种类数
     * 问题变成：不同的 k 之下，等号右边的乘积，进行累加。
     *
     * 定义 dp[i] ：用连着的 i 个数，所构建出的 BST 种类数
     */
    public int numTrees(int n) {
        // dp[i] 代表以第 i 个为根节点组成的 BST
        int[] dp = new int[n+1];
        // 没有节点，只能形成空的 BST
        dp[0] = 1;
        // 只有一个节点，只能形成一颗 BST
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // 左侧 i-1 个节点与右侧 i-j-1 个节点能组成的 BST
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
