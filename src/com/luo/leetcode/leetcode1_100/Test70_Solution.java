package com.luo.leetcode.leetcode1_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luoxusheng 2020/8/1 14:22
 * @version 1.0.0
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 示例 3：
 *
 * 输入：4
 * 输出：5
 * 1. 1 阶 + 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶 + 1 阶
 * 3. 2 阶 + 1 阶 + 1 阶
 * 4. 1 阶 + 1 阶 + 2 阶
 * 5. 2 阶 + 2 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test70_Solution {

    private static Map<Integer, Integer> cache = new HashMap<>();

    // f(n) = f(n-1) + f(n-2)
    public static int climbStairs1(int n) {
        if (0 == n) {
            cache.put(0, 0);
            return 0;
        }
        if (1 == n) {
            cache.put(1, 1);
            return 1;
        }
        if (2 == n) {
            cache.put(2, 2);
            return 2;
        }
        if (cache.get(n) != null) {
            return cache.get(n);
        }
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, result);
        return result;
    }

    public static int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

}
