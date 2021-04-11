package com.phorse.monkey.leetcode.leetcode200_300;

/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * <p>
 * 丑数 就是只包含质因数2、3 和/或5的正整数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 *
 * @author luoxusheng 2021/4/11 15:00
 * @version v1.0.0
 */
public class Test264_Solution {

    /**
     * 思路：动态规划
     *  1. 定义3个指针，p2,p3,p5表示丑数集合中还没乘过 2，3，5 的丑数位置
     *  2. 每次新的丑数 dp[i] = min(dp[p2] * 2, dp[p3] * 3, dp[p5] * 5)
     *  3. 根据 dp[i] 是由 p2, p3, p5 中的哪个相乘得到的，对应的把此指针 + 1，表示还没乘过该 index 的最小丑数变大了。
     *  注：（最小数可能相等，对应多个指针都同时增加，避免重复计算）
     */
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
