package com.phorse.monkey.leetcode.leetcode1_100;

/**
 * @Description: 整数反转
 * @Auther: luo
 * @Date: 2020/2/29 23:45
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test7_Solution {

    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean flag = true;
        if (x < 0) {
            x = x * -1;
            flag = false;
        }
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        char[] newChar = new char[chars.length];
        int j = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            newChar[j] = chars[i];
            j++;
        }
        String newStr = String.valueOf(newChar);
        try {
            return flag ? Integer.valueOf(newStr) : Integer.valueOf(newStr) * -1;
        }catch (Exception e){
            return 0;
        }
    }

    public static int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse1(1999999999));
    }
}
