package com.luo.leetcode.interview;

/**
 * @Description: 合并排序的数组
 * @Auther: luo
 * @Date: 2020/3/3 02:33
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,0,0,1,2,0,0], m = 2
 * B = [2,5,6,7],       n = 4
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InterView1001_Soultion {

    public static void merge(int[] A, int m, int[] B, int n) {
        //将A移动到末尾
        System.arraycopy(A, 0, A, n, m);
        int index = 0;
        int a, b;
        for (a = n, b = 0; a < m + n && b < n; ) {
            if (A[a] <= B[b]) {
                A[index++] = A[a++];
            } else {
                A[index++] = B[b++];
            }
        }
        if (m >= n) {
            while (a < m + n) {
                A[index++] = A[a++];
            }
        } else {
            while (b < n) {
                A[index++] = B[b++];
            }
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 0, 0, 0, 0, 0};
        int[] b = new int[]{2, 5, 6, 7};
        int m = 3;
        int n = 4;
        merge(a, m, b, n);
        // 1245  3
    }


    /**
     * // 先将A右移到末尾
     *         System.arraycopy(A, 0, A, n, m);
     *
     *         int index = 0;
     *         int a, b;
     *         for (a = n, b = 0; a < m + n && b < n; ) {
     *             if (A[a] <= B[b]) {
     *                 A[index++] = A[a++];
     *             } else {
     *                 A[index++] = B[b++];
     *             }
     *         }
     *
     *         while (a < m + n) {
     *             A[index++] = A[a++];
     *         }
     *
     *         while (b < n) {
     *             A[index++] = B[b++];
     *         }
     */
}
