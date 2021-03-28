package com.phorse.monkey.leetcode.leetcode1_100;

import java.util.Arrays;

/**
 * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3<= nums[i]<= 10^3
 * -10^4<= target<= 10^4
 *
 * @author luoxusheng 2021/3/19 19:10
 * @version v1.0.0
 */
public class Test16_Solution {

    /**
     * 解题思路：优先排序 + 双指针，固定一个数，
     * 1. 优先排序，保证数组有序性
     * 2. 在数组 nums 中，进行遍历，每遍历一个值利用其下标i，形成一个固定值 nums[i]
     * 3. 再使用前指针指向 start = i + 1 处，后指针指向 end = nums.length - 1 处，也就是结尾处
     * 4. 判断 sum 与目标 target 的距离，如果更近则更新结果 ans
     * 5. 同时判断 sum 与 target 的大小关系，因为数组有序，如果 sum > target 则 end--，如果 sum < target 则 start++，如果 sum == target 则说明距离为 0 直接返回结果
     * <p>
     * 总时间复杂度：O(nlogn) + O(n^2) = O(n^2)
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int tmpSum = nums[i] + nums[start] + nums[end];
                if (tmpSum == target) {
                    return tmpSum;
                }
                if (Math.abs(target - tmpSum) < Math.abs(target - ans)) {
                    ans = tmpSum;
                }
                if (tmpSum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
