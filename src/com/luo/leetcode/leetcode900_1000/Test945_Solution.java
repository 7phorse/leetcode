package com.luo.leetcode.leetcode900_1000;

import java.util.*;

/**
 * @Description: 使数组唯一的最小增量
 * @Auther: luo
 * @Date: 2020/3/22 15:28
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * <p>
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 示例 2:
 * <p>
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test945_Solution {

    public static int minIncrementForUnique(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        // 112237
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                queue.add(arr[i]);
            }
            set.add(arr[i]);
        }

        int first = arr[0];
        while (!queue.isEmpty()){
            if(set.contains(first)){
                first++;
                continue;
            }
            Integer poll = queue.poll();
            res = res + (first - poll);
            set.add(first);
            first++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    }

}
