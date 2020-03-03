package com.luo.sort.selectsort;

import com.luo.model.Student;

import java.util.Arrays;

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

        // 测试Integer
        Integer[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SelectionSort.sort(a);
        System.out.println(Arrays.toString(a));

        // 测试Double
        Double[] b = {4.4, 3.3, 2.2, 1.1};
        SelectionSort.sort(b);
        System.out.println(Arrays.toString(b));
        // 测试String
        String[] c = {"D", "C", "B", "A"};
        SelectionSort.sort(c);
        System.out.println(Arrays.toString(c));

        // 测试自定义的类 Student
        Student[] d = new Student[4];
        d[0] = new Student("D", 90);
        d[1] = new Student("C", 100);
        d[2] = new Student("B", 95);
        d[3] = new Student("A", 95);
        SelectionSort.sort(d);
        System.out.println(Arrays.toString(d));
    }
}
