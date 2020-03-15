package com.luo.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Auther: luo
 * @Date: 2020/3/13 00:57
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test169_Solution {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = nums.length/2;
        for (int i = 0; i < nums.length; i++) {
            Integer cnt = map.get(nums[i]);
            if(cnt==null){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],cnt+1);
            }
            if(map.get(nums[i]) > index){
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
    }
}
