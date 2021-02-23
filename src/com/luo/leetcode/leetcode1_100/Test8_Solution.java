package com.luo.leetcode.leetcode1_100;

/**
 * @Description: 字符串转换整数 (atoi)
 * @Auther: luo
 * @Date: 2020/3/1 23:45
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test8_Solution {
    private static final char[] numStr = new char[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

    public static int myAtoi(String str) {
        if(str.length()==0){
            return 0;
        }
        char[] chars = str.toCharArray();
        int first = 0;
        int index = 1;
        // 寻找first
        // 寻找last
        // 转换int
        for (int i = 0; i < chars.length; i++) {
            if ((" ".charAt(0) == chars[i])) {
                first++;
                continue;
            }
            if ("+".charAt(0) == chars[i]) {
                first++;
                break;
            } else if ("-".charAt(0) == chars[i]) {
                first++;
                index = -1;
                break;
            } else if (containsNum(chars[i])) {
                break;
            } else {
                return 0;
            }
        }
        if(first >= chars.length){
            return 0;
        }
        int last = first + 1;
        for (int i = last; i < chars.length; i++) {
            if (containsNum(chars[i])) {
                last++;
                continue;
            }
            break;
        }
        if(containsNum(chars[first])){
            try {
                return Integer.valueOf(str.substring(first, last)) * index;
            } catch (Exception e) {
                return index > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }else {
            return 0;
        }
    }

    private static boolean containsNum(char aChar) {
        return aChar >= '0' && aChar <= '9';
    }

    public static void main(String[] args) {
        String s = "+";
        System.out.println(myAtoi(s));
    }
}
