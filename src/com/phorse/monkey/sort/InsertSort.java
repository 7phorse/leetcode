package com.phorse.monkey.sort;

import com.phorse.monkey.utils.SortTestHelper;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: luo
 * @Date: 2020/3/8 09:48
 */
public class InsertSort {

    // 我们的算法类不允许产生任何实例
    private InsertSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {

            // 寻找元素arr[i]合适的插入位置

            // 写法1
//            for( int j = i ; j > 0 ; j -- )
//                if( arr[j].compareTo( arr[j-1] ) < 0 )
//                    swap( arr, j , j-1 );
//                else
//                    break;

            // 写法2
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }

        }
    }

    public static void insertSort(int[] arr) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("共执行:" + (endTime - startTime) + "ms");
    }

//    public static void insertSort2(int[] arr) {
//        long startTime = System.currentTimeMillis();
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = i; j > 0; j--) {
//                arr[j] = arr[j-1];
//                int tmp = arr[j];
//                if (tmp > arr [j-1]){
//
//                }
//            }
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("共执行:" + (endTime - startTime) + "ms");
//    }

    /**
     * 1,3,5,2,4,6
     *
     * 1:135246
     * 2:
     */
    public static void insertSort2(int[] arr){
        long startTime = System.currentTimeMillis();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 寻找元素arr[i]合适的插入位置
            int tmp = arr[i];
            int j = i;
            for( ; j > 0 && arr[j-1] > tmp ; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;

        }
        long endTime = System.currentTimeMillis();
        System.out.println("共执行:" + (endTime - startTime) + "ms");
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        // 测试排序算法辅助函数
        int n = 50;
        int[] arr = SortTestHelper.generateArrRandomArray(n, 0, 500);
//        insertSort(arr);
        insertSort2(new int[]{1,3,5,2,4,6});
        System.out.println(Arrays.toString(arr));
    }
}
