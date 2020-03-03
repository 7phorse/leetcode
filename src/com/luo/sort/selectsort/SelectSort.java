package com.luo.sort.selectsort;

import com.luo.utils.ArrayUtils;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: luo
 * @Date: 2020/3/4 00:44
 */
public class SelectSort {

    public static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            ArrayUtils.swap(arr, minIndex, i);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectSort(new int[]{2, 3, 4, 1, 2, 6, 7, 5})));
    }
}
