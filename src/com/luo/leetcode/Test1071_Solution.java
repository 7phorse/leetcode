package com.luo.leetcode;

/**
 * @Description: 字符串的最大公因子
 * @Auther: luo
 * @Date: 2020/3/12 01:22
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * <p>
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * <p>
 * 示例 1：
 * <p>
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 * <p>
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 * <p>
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test1071_Solution {

    public static String gcdOfStrings(String str1, String str2) {
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法求gcd。
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC","ABC"));
    }
}
