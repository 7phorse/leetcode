package com.phorse.monkey.leetcode.leetcode1100_1200;

import java.util.HashMap;
import java.util.Map;

/**
 * 泰波那契序列Tn定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 *
 * @author luoxusheng 2021/8/8 11:55
 * @version v1.0.0
 */
public class Test1137_Solution {

    private final static Map<Integer, Integer> MAP = new HashMap<>();

    /**
     * 注：要点在于将重复计算的值进行缓存
     */
    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (MAP.containsKey(n)) {
            return MAP.get(n);
        }
        int res = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        MAP.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }
}
