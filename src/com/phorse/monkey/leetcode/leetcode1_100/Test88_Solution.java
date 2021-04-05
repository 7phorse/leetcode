package com.phorse.monkey.leetcode.leetcode1_100;

import com.phorse.monkey.utils.ArrayUtils;

/**
 * @author luoxusheng 2020/8/5 14:01
 * @version 1.0.0
 * <p>
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。
 * 你可以假设nums1有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出:[1,2,2,3,5,6]
 */
public class Test88_Solution {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int idx = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                res[idx++] = nums1[i++];
            } else {
                res[idx++] = nums2[j++];
            }
        }
        while (i < m) {
            res[idx++] = nums1[i++];
        }
        while (j < n) {
            res[idx++] = nums2[j++];
        }
        System.arraycopy(res, 0, nums1, 0, idx);
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        ArrayUtils.printArr(num1);
        System.out.println("");
        ArrayUtils.printArr(num2);
        System.out.println("");
        merge(num1, 3, num2, 3);
        ArrayUtils.printArr(num1);
        System.out.println("");

    }

}
