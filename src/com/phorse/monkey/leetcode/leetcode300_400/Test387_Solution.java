package com.phorse.monkey.leetcode.leetcode300_400;

/**
 * @author luoxusheng 2020/12/23 09:21
 * @version 1.0.0
 */
public class Test387_Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0; i<flowerbed.length; i++){
            if(flowerbed[i] == 0 && (i==0 || flowerbed[i-1]==0) && (i==flowerbed.length-1 || flowerbed[i+1]==0)){
                n--;
                flowerbed[i] = 1;
                if(n==0){
                    return true;
                }
            }
        }
        return n <= 0;
    }


}
