package com.luo.leetcode.leetcode1_100;

/**
 * @Description: 最长回文子串
 * @Auther: luo
 * @Date: 2020/3/14 21:05
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test5_Solution {

    public static String longestPalindrome(String s) {
        if (s.equals("")) {
            return "";
        }
        int length = s.length();
        String reversal = new StringBuffer(s).reverse().toString(); // 反转字符串
        int[][] cell = new int[length][length];
        int maxLen = 0; // 最长公共子串长度
        int maxEnd = 0; // 最长公共子串结束位置
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (reversal.charAt(i) == s.charAt(j)) {
                    if (i == 0 || j == 0) {
                        cell[i][j] = 1;
                    } else {
                        cell[i][j] = cell[i - 1][j - 1] + 1; // 公共子串长度
                    }
                } else {
                    cell[i][j] = 0;
                }
                if (cell[i][j] > maxLen) {
                    maxLen = cell[i][j];
                    maxEnd = j;
                }
            }
        }
        return s.substring(maxEnd + 1 - maxLen, maxEnd + 1);
    }

    public static String longestPalindrome1(String s) {
        if(s.equals("")){
            return "";
        }
        if(s.length() == 1){
            return s;
        }
        int start = 0;
        int end = 1;
        int max = 1;
        for (int i = 0; i < s.length()/2; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String origin = s.substring(i, j);
                String newStr = reserve(origin);
                if(origin.equals(newStr) && j-i > max){
                    max = j-i;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start,end);
    }

    private static String reserve(String origin) {
        if (origin == null){
            return "";
        }
        char[] newChar = new char[origin.length()];
        int j = 0;
        for (int i = origin.length()-1; i >= 0 ; i--) {
            newChar[j++] = origin.charAt(i);
        }
        return new String(newChar);
    }

    public String longestPalindrome3(String s) {
        if (s.equals("")) {
            return "";
        }
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString(); //字符串倒置
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > maxLen) {
                    maxLen = arr[i][j];
                    maxEnd = i; //以 i 位置结尾的字符
                }

            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome1("azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc"));
    }
}
