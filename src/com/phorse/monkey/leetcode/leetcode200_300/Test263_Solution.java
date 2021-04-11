package com.phorse.monkey.leetcode.leetcode200_300;

/**
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 丑数 就是只包含质因数2、3 和/或5的正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * 示例 2：
 * <p>
 * 输入：n = 8
 * 输出：true
 * 解释：8 = 2 × 2 × 2
 * 示例 3：
 * <p>
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数7 。
 * 示例 4：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 解释：1 通常被视为丑数。
 *
 * @author luoxusheng 2021/4/11 14:44
 * @version v1.0.0
 */
public class Test263_Solution {

    /**
     * 思路：按顺序判断是否能被2，3，5整除，最后若不断运算结果为1，则证明该数为丑数
     */
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        if (n == 1) {
            return true;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        if (n == 1) {
            return true;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        if (n == 1) {
            return true;
        }
        return false;
    }
}
