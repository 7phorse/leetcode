package com.luo.utils;

public class ArrayUtils {
    /**
     定义一个获取int数组中最大值的功能
     1：确定结果；返回值类型为int
     2；未知内容，要获取哪个数组中的最大值不确定，数组就是未知内容，需要定义成参数。
     思路：1：定义一个变量，记录住数组中比较大的元素，因为该元素是不确定的，该变量初始化成任意一个元素即可，
     2；遍历数组，让数组中每一个元素和改变量进行比较
     3;当遍历到的原数比记录的元数大时，需要将该变量记录住比较大的元素，当循环结束，该变量就是数组中的最大值
     */
     public static int getMax(int[] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
           if(arr[i]>max){
               max=arr[i];
           }
        }
        return max;
     }

     public static void printArr(int[] arr){
         for (int i=0;i<arr.length;i++){
             System.out.print(arr[i]+" ");
         }
     }



}
