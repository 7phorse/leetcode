package com.phorse.monkey.leetcode.leetcode1_100;

/**
 * x 的平方根
 *
 * @author luoxusheng 2020/7/27 13:37
 * @version 1.0.0
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 5
 * 0,5 -- mid 2
 */
public class Test69_Solution {

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long left = 0;
        long right = x;
        long result = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
