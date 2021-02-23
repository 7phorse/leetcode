package com.phorse.monkey.leetcode.leetcode100_200;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luoxusheng 2021/1/23 17:23
 * @version 1.0.0
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 *
 * 输入：triangle = [[-10]]
 * 输出：-10
 *  
 *
 * 提示：
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 */
public class Test120_Solution {

    private Map<String, Integer> cache = new HashMap<>();

    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        if (cache.get(String.format("%d_%d", i, j)) != null) {
            return cache.get(String.format("%d_%d", i, j));
        }
        int result = Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
        cache.put(String.format("%d_%d", i, j), result);
        return result;
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        int res = triangle.get(0).get(0);
        int index = 0;
        for (int i = 1; i < triangle.size(); i++) {
            Integer tmp1 = triangle.get(i).get(index);
            Integer tmp2 = triangle.get(i).get(index + 1);
            if (tmp1 < tmp2) {
                res += tmp1;
            } else {
                res += tmp2;
                index = index + 1;
            }
        }
        return res;
    }
}
