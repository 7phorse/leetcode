package com.luo.leetcode.leetcode300_400;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: luo
 * @Date: 2020/3/8 08:56
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test322_Solution {

    public static int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        Arrays.sort(coins);
        int res = 0;
        int balance = amount;
        for (int i = coins.length - 1; i >= 0; i--) {
            int index = balance / coins[i];
            if (index == 0){
                continue;
            }
            res = res + index;
            balance = balance - index * coins[i];
        }
        if(balance == 0){
            return res > 0 ? res : -1;
        }
        return -1;
    }

    public static int coinChange1(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        System.out.println(coinChange1(coins, 11));
    }
}
