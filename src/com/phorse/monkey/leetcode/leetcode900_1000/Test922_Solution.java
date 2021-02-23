package com.phorse.monkey.leetcode.leetcode900_1000;

import com.phorse.monkey.utils.ArrayUtils;

/**
 * @author luoxusheng 2020/11/12 13:46
 * @version 1.0.0
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 */
public class Test922_Solution {

    public static int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    public static int[] sortArrayByParityII(int[] A) {
//        int[] res = new int[A.length];
//        ArrayDeque<Integer> queueA = new ArrayDeque<>();
//        ArrayDeque<Integer> queueB = new ArrayDeque<>();
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] % 2 == 0) {
//                queueB.push(A[i]);
//            } else {
//                queueA.push(A[i]);
//            }
//        }
//        for (int i = 0; i < A.length; i++) {
//            res[i] = i % 2 == 0 ? queueB.poll() : queueA.poll();
//        }
//        return res;
//    }

    public static void main(String[] args) {
        int[] res = sortArrayByParityII(new int[] {4, 2, 2, 2, 3, 5, 7, 9});
        ArrayUtils.printArr(res);
    }
}
