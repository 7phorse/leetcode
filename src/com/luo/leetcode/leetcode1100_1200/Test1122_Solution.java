package com.luo.leetcode.leetcode1100_1200;

import com.luo.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luoxusheng 2020/11/14 18:55
 * @version 1.0.0
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test1122_Solution {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> arr2List = new ArrayList<>();
        List<Integer> preList = new ArrayList<>();
        List<Integer> lastList = new ArrayList<>();

        for (int i : arr2) {
            arr2List.add(i);
        }
        for (int i : arr1) {
            if (arr2List.contains(i)) {
                map.merge(i, 1, (a, b) -> a + b);
            } else {
                lastList.add(i);
            }
        }

        for (int anArr2 : arr2) {
            for (int j = 0; j < map.get(anArr2); j++) {
                preList.add(anArr2);
            }
        }
        int[] pre = preList.stream().mapToInt(Integer::valueOf).toArray();
        int[] last = lastList.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(last);
        int[] res = new int[arr1.length];
        System.arraycopy(pre, 0, res, 0, pre.length);
        System.arraycopy(last, 0, res, pre.length, last.length);
        return res;
    }

    public static void main(String[] args) {
        int[] ints = relativeSortArray(new int[] {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[] {2, 1, 4, 3, 9, 6});
        ArrayUtils.printArr(ints);
    }
}
