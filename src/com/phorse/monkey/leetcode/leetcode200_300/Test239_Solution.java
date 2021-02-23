package com.phorse.monkey.leetcode.leetcode200_300;

import com.phorse.monkey.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author luoxusheng 2021/1/2 13:21
 * @version 1.0.0
 */
public class Test239_Solution {
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[] {nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        assert pq.peek() != null;
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[] {nums[i], i});
            while (Objects.requireNonNull(pq.peek())[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int l = 0;
        int r = k - 1;
        List<Integer> list = new ArrayList<>();
        while (r < nums.length) {
            int tmp = calMax(l, r, nums);
            list.add(tmp);
            l++;
            r++;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static int calMax(int l, int r, int[] nums) {
        int max = nums[l];
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints = maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3);
        ArrayUtils.printArr(ints);
    }
}
