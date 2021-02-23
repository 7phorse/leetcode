package com.phorse.monkey.leetcode.leetcode100_200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luoxusheng 2021/1/2 15:27
 * @version 1.0.0
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Test118_Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            if (i == 0) {
                tmp.add(1);
                res.add(tmp);
                continue;
            }
            if (i == 1) {
                tmp.add(1);
                tmp.add(1);
                res.add(tmp);
                continue;
            }
            List<Integer> pre = res.get(i-1);
            tmp.add(1);
            for (int j = 1; j < i; j++) {
                tmp.add(pre.get(j-1) + pre.get(j));
            }
            tmp.add(1);
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(3);
        System.out.println(generate);
    }
}
