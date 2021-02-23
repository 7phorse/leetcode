package com.phorse.monkey.leetcode.leetcode1300_1400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luoxusheng 2020/10/26 13:40
 * @version 1.0.0
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 *
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test1365_Solution {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        if(nums.length == 0){
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int[] originalArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
               continue;
            }
            map.put(nums[i], i);
        }
        for (int i = 0; i < originalArr.length; i++) {
            result[i] = map.get(originalArr[i]);
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[] {8,1,2,2,3})));

    }
}
