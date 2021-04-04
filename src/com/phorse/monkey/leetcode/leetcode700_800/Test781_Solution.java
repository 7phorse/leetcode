package com.phorse.monkey.leetcode.leetcode700_800;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在answers数组里。
 * <p>
 * 返回森林中兔子的最少数量。
 * <p>
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 * <p>
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 * <p>
 * 输入: answers = []
 * 输出: 0
 *
 * @author luoxusheng 2021/4/4 15:48
 * @version v1.0.0
 */
public class Test781_Solution {

    /**
     * 思路：数学问题，先分组，假设有x只兔子说有y只相同颜色，则至少有（x / y + 1）向上取整，种颜色，每种颜色有y + 1只兔子。
     */
    public static int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }
        AtomicInteger res = new AtomicInteger();
        map.forEach((y, x) -> {
            int color = (x + y) / (y + 1);// y是为了向上取整
            res.addAndGet(color * (y + 1));
        });
        return res.get();
    }

    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{10, 10, 10}));
    }
}
