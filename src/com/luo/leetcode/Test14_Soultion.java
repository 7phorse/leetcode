package com.luo.leetcode;

/**
 * @Description: 最长公共前缀
 * @Auther: luo
 * @Date: 2020/3/4 13:07
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test14_Soultion {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int index = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char tmp = strs[0].charAt(index);
            for (int j = 1; j < strs.length; j++) {
                if (index >= strs[j].length()) {
                    return strs[0].substring(0, index);
                }
                if (tmp != strs[j].charAt(index)) {
                    if (index == 0) {
                        return "";
                    }
                    return strs[0].substring(0, index);
                }
            }
            index++;
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] str = new String[]{"aa", "ab", "abc"};
        System.out.println(longestCommonPrefix(str));
    }
}
