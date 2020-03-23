package com.luo.leetcode;

/**
 * @Description:
 * @Auther: luo
 * @Date: 2020/3/19 20:39
 */
public class InterView63_Solution {

    public static int maxProfit(int[] prices) {

        int min = prices[0];
        int profit = -1;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i],min);
            profit = Math.max(prices[i] - min,profit);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
