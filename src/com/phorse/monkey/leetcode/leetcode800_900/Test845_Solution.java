package com.phorse.monkey.leetcode.leetcode800_900;

/**
 * @author luoxusheng 2020/10/25 17:08
 * @version 1.0.0
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test845_Solution {

    public static  int aa(int[] A){
        int n = A.length;
        if (n < 3) {
            return 0;
        }
        int[] left = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }

    public static int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int index = 0;
        int max = 0;
        for (int i = 1; i < A.length - 1; i++) {
            // 计算左边长度
            int l = calLeft(i, A, index);
            // 计算右边长度
            int r = calRight(i, A);
            if (l == 0 || r == 0) {
                continue;
            }
            int tmp = l + r + 1;
            index = r > 0 ? i + r : index;
            max = tmp > max ? tmp : max;
        }
        return max;

    }

    private static int calLeft(int i, int[] arr, int index) {
        int result = 0;
        while (i > index) {
            if (arr[i - 1] < arr[i]) {
                result++;
                i--;
            } else {
                break;
            }
        }
        return result;
    }

    private static int calRight(int i, int[] arr) {
        int result = 0;
        while (i + 1 < arr.length) {
            if (arr[i + 1] < arr[i]) {
                result++;
                i++;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(calLeft(3, new int[] {2, 1, 4, 7, 3, 2, 5}));
        System.out.println(longestMountain(new int[] {875,884,239,731,723,685}));
    }
}
