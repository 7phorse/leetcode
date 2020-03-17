package com.luo.leetcode;

import java.util.TreeSet;

/**
 * @Description: 第三大的数
 * @Auther: luo
 * @Date: 2020/3/16 18:03
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 2, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 第三大的数是 1.
 * 示例 2:
 * <p>
 * 输入: [1, 2]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 * <p>
 * 输入: [2, 2, 3, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test414_Solution {

//    public static int thirdMax1(int[] nums) {
//        PriorityQueue<Integer> heap =
//                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
//
//        for (int n: nums) {
//            heap.add(n);
//            if (heap.size() > 3) {
//                heap.poll();
//            }
//        }
//        // output
//        return heap.poll();
//    }

    public static int thirdMax(int[] nums) {

        TreeSet<Integer> set = new TreeSet<>();
        for (Integer elem : nums) {
            set.add(elem);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        // set.last() 里面最大的元素
        return set.size() < 3 ? set.last() : set.first();
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{2, 2, 3, 1, 4, 5, 6}));
    }
}
