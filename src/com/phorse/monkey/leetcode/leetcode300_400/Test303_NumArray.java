package com.phorse.monkey.leetcode.leetcode300_400;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组nums，求出数组从索引i到j（i≤j）范围内元素的总和，包含i、j两点。
 * <p>
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引i到j（i≤j）范围内元素的总和，包含i、j两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 * <p>
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 104
 * -105<= nums[i] <=105
 * 0 <= i <= j < nums.length
 * 最多调用 104 次 sumRange 方法
 *
 * @author luoxusheng 2021/3/1 15:34
 * @version v1.0.0
 */
public class Test303_NumArray {

    List<Integer> list = new ArrayList<>();

    public Test303_NumArray(int[] nums) {
        for (int num : nums) {
            list.add(num);
        }
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += list.get(k);
        }
        return sum;
    }

    public static void main(String[] args) {
        Test303_NumArray numArray = new Test303_NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(2, 5));
    }
}
