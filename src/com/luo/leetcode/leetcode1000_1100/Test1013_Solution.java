package com.luo.leetcode.leetcode1000_1100;

/**
 * @Description:
 * @Auther: luo
 * @Date: 2020/3/11 10:29
 * <p>
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * <p>
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 * <p>
 * 示例 1：
 * <p>
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 * <p>
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 50000
 * -10^4 <= A[i] <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test1013_Solution {

    public static boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int i = 0;
        int left = arr[0];
        int j = arr.length - 1;
        int right = arr[arr.length - 1];
        while (j > i + 1) {
            if (left == sum / 3 && right == sum / 3) {
                // 左右两边都等于 sum/3 ，中间也一定等于
                return true;
            }
            if (left != sum / 3) {
                // left = 0赋予了初值，应该先left++，在leftSum += A[left];
                i++;
                left += arr[i];
            }
            if (right != sum / 3) {
                // right = 0赋予了初值，应该先right--，在rightSum += A[right];
                j--;
                right += arr[j];
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
        System.out.println(canThreePartsEqualSum(arr));
    }
}
