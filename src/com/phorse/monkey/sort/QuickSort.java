package com.phorse.monkey.sort;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: luo
 * @Date: 2020/3/8 12:24
 */
public class QuickSort {

//    public static void sort(int[] arr) {
//        sort(arr, 0, arr.length - 1);
//    }
//
//    private static void sort(int[] arr, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int p = partition(arr, left, right);
//        sort(arr, left, p - 1);
//        sort(arr, p + 1, right);
//
//    }
//
//    private static int partition(int[] arr, int left, int right) {
//        int v = arr[left];
//        int j = left;
//        for (int i = left + 1; i < right; i++) {
//            if (arr[i] < v) {
//                ArrayUtils.swap(arr, j + 1, i);
//                j++;
//            }
//        }
//        ArrayUtils.swap(arr, left, j);
//        return j;
//    }

    /**
     * 对arr[l...r]部分进行partition操作
     * 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
     */
    private static int partition(int[] arr, int l, int r) {
        int v = arr[l];
        // arr[l+1...j] < v ; arr[j+1...i) > v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }

    /**
     * 递归使用快速排序,对arr[l...r]的范围进行排序
     */
    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
