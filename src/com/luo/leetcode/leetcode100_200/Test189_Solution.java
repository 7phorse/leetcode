package com.luo.leetcode.leetcode100_200;

import com.luo.utils.ArrayUtils;

/**
 * @author luoxusheng 2021/1/8 21:47
 * @version 1.0.0
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 */
public class Test189_Solution {

    public static void rotate(int[] nums, int k) {
        int index = k % nums.length;
        if (index == 0) {
            return;
        }
        reserve(nums, 0, nums.length - 1);
        reserve(nums, 0, index - 1);
        reserve(nums, index, nums.length - 1);

    }

    private static void reserve(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }

    }

//    public static void rotate(int[] nums, int k) {
//        int index = k % nums.length;
//        if (index == 0) {
//            return;
//        }
//        int[] tmp = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            if (i < index) {
//                tmp[i] = nums[nums.length - index + i];
//            } else {
//                tmp[i] = nums[i - index];
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = tmp[i];
//        }
//
//    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        rotate(ints, 3);
        ArrayUtils.printArr(ints);
    }

}
