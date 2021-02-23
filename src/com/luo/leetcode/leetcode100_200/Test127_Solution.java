package com.luo.leetcode.leetcode100_200;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

/**
 * @author luoxusheng 2020/11/5 00:03
 * @version 1.0.0
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class Test127_Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int count = 1;

        HashSet<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.addLast(beginWord);
        HashSet<String> index = new HashSet<>();
        index.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.removeFirst();
                char[] chars = temp.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char ch = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == ch) {
                            continue;
                        }

                        chars[j] = c;
                        String str = toStr(chars);
                        if (str.equals(endWord)) {
                            index.add(str);
                            return count + 1;
                        }
                        if (!index.contains(str) && wordSet.contains(str)) {
                            queue.addLast(str);
                            index.add(str);
                        }
                    }
                    chars[j] = ch;
                }
            }
            count++;
        }

        return index.contains(endWord) ? count : 0;
    }

    private String toStr(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            sb.append(ch);
        }
        return sb.toString();
    }

}
