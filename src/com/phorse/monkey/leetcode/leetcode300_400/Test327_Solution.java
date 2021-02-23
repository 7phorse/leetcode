package com.phorse.monkey.leetcode.leetcode300_400;

/**
 * @author luoxusheng 2020/11/7 23:44
 * @version 1.0.0
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 *
 * 说明:
 * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
 *
 * 示例:
 *
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 *
 */
public class Test327_Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = 0;
            for (int j = i; j < nums.length; j++) {
                index = index + nums[j];
                if(index >= lower && index<=upper){
                    result++;
                }
            }
        }
        return result;
    }



}
