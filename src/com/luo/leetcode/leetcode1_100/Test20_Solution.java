package com.luo.leetcode.leetcode1_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description: 有效的括号
 * @Auther: luo
 * @Date: 2020/3/5 19:41
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test20_Solution {


    private static Map<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

    public static boolean isValid(String str) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {

            if (map.containsKey(str.charAt(i))) {
                char tmp = stack.empty() ? '#' : stack.pop();
                if(tmp != map.get(str.charAt(i))){
                    return false;
                }
            } else {
                stack.push(str.charAt(i));
            }
        }
        return stack.empty();
    }


//    /**
//     * Hash table that takes care of the mappings.
//     */
//    private static HashMap<Character, Character> mappings = new HashMap<>();
//
//    /**
//     * Initialize hash map with mappings. This simply makes the code easier to read.
//     */
//    static {
//        mappings = new HashMap<Character, Character>();
//        mappings.put(')', '(');
//        mappings.put('}', '{');
//        mappings.put(']', '[');
//    }
//
//    public static boolean isValid(String s) {
//
//        // Initialize a stack to be used in the algorithm.
//        Stack<Character> stack = new Stack<Character>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            // If the current character is a closing bracket.
//            if (mappings.containsKey(c)) {
//
//                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
//                char topElement = stack.empty() ? '#' : stack.pop();
//
//                // If the mapping for this bracket doesn't match the stack's top element, return false.
//                if (topElement != mappings.get(c)) {
//                    return false;
//                }
//            } else {
//                // If it was an opening bracket, push to the stack.
//                stack.push(c);
//            }
//        }
//
//        // If the stack still contains elements, then it is an invalid expression.
//        return stack.isEmpty();
//    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

}
