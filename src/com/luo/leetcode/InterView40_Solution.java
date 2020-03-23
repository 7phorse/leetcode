package com.luo.leetcode;

import com.luo.utils.ArrayUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description: 最小的k个数
 * @Auther: luo
 * @Date: 2020/3/20 11:07
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class InterView40_Solution {


    public static int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayUtils.printArr(getLeastNumbers(new int[]{0,1,2,1}, 1));
    }
}
