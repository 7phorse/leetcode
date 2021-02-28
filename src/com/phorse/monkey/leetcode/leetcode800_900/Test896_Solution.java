package com.phorse.monkey.leetcode.leetcode800_900;

/**
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * <p>
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * <p>
 * 当给定的数组 A是单调数组时返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,2,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：[6,5,4,4]
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：[1,3,2]
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：[1,2,4,5]
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：[1,1,1]
 * 输出：true
 *
 * @author luoxusheng 2021/2/28 22:05
 * @version v1.0.0
 */
public class Test896_Solution {

    /**
     * 思路：遍历一次
     * 1. 定义两个状态，标识数组是递增还是递减，默认false
     * 2. 遍历数组，value相等则跳过循环
     * 3. 判断大小修改asc,desc的值
     * 4. 若asc 和 desc均为true时则代表非单调数列，返回false
     *
     * @author luoxusheng 2021/2/28 22:26
     */
    public boolean isMonotonic(int[] A) {
        boolean asc = false;
        boolean desc = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                continue;
            }
            if (A[i] > A[i - 1]) {
                asc = true;
            }
            if (A[i] < A[i - 1]) {
                desc = true;
            }
            if (asc && desc) {
                return false;
            }
        }
        return true;
    }

}
