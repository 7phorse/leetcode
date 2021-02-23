package com.phorse.monkey.sort.selectsort;

import com.phorse.monkey.utils.SortTestHelper;

/**
 * @Description:
 * @Auther: luo
 * @Date: 2020/3/4 01:14
 */
public class SelectionSort {
    // 我们的算法类不允许产生任何实例
    private SelectionSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            // 使用compareTo方法比较两个Comparable对象的大小
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        // 测试排序算法辅助函数
        int n = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 100000);
        SortTestHelper.testSort("com.luo.sort.selectsort.SelectionSort", arr);
    }
}
