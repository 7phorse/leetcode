package com.phorse.monkey.leetcode.leetcode100_200;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author luoxusheng 2021/1/2 15:42
 * @version 1.0.0
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 */
public class Test119_Solution {
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
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
        return res.get(rowIndex);
    }

    public static void main(String[] args) {
        List<Integer> row = getRow(4);
        System.out.println(row);
    }
}
