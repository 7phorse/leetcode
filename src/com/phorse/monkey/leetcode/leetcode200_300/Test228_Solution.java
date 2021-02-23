package com.phorse.monkey.leetcode.leetcode200_300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luoxusheng 2021/1/10 19:23
 * @version 1.0.0
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 *
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 示例 3：
 *
 * 输入：nums = []
 * 输出：[]
 */
public class Test228_Solution {

    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> resultList = new ArrayList<>();
        if(nums.length == 1){
            resultList.add(String.valueOf(nums[0]));
            return resultList;
        }
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                end = nums[i];
                continue;
            }
            if (start == end) {
                resultList.add(String.valueOf(start));
            } else {
                resultList.add(start + "->" + end);
            }
            start = nums[i];
            end = nums[i];
        }
        if (start == end) {
            resultList.add(String.valueOf(start));
        } else {
            resultList.add(start + "->" + end);
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[] {0,2,3,4,6,8,9}));
    }
}
