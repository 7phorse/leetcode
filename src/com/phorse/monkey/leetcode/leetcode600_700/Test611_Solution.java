package com.phorse.monkey.leetcode.leetcode600_700;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 *
 * @author luoxusheng 2021/8/4 13:14
 * @version v1.0.0
 */
public class Test611_Solution {

    public static int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            for (int j = i + 1; j <= nums.length - 2; j++) {
                int index = nums[i] + nums[j];
                for (int k = j + 1; k <= nums.length - 1; k++) {
                    if (index <= nums[k]) {
                        break;
                    }
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2, 2, 3, 4}));
    }
}
