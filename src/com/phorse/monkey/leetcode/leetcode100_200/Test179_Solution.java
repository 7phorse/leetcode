package com.phorse.monkey.leetcode.leetcode100_200;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 3,30 -> 330
 * 330, 34 -> 34330
 * 34330, 5 -> 534330
 * 输出："9534330"
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 * <p>
 * 输入：nums = [10]
 * 输出："10"
 *
 * @author luoxusheng 2021/4/12 13:49
 * @version v1.0.0
 */
public class Test179_Solution {

    /**
     * 思路：优先对数组进行字母序排序，随后依次比较字符串拼接大小
     */
    public static String largestNumber(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }

        Comparator<String> comparator = (a, b) -> {
            String sa = a + b, sb = b + a;
            return sb.compareTo(sa);
        };
        List<String> list = Arrays.stream(nums).mapToObj(String::valueOf).sorted(comparator).collect(Collectors.toList());
        if (list.get(0).equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{128, 12, 320, 32}));
    }
}
