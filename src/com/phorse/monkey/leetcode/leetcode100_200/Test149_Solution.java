package com.phorse.monkey.leetcode.leetcode100_200;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 * 示例 2：
 * <p>
 * <p>
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * points 中的所有点 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-points-on-a-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author luoxusheng 2021/7/25 15:27
 * @version v1.0.0
 */
public class Test149_Solution {

    /**
     * 解题思路：同447题，使用哈希表记录有相同斜率点的个数
     *
     * @return
     */
    public int maxPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    double k = ((double) points[j][1] - points[i][1]) / ((double) points[j][0] - points[i][0]);
                    map.put(k, map.getOrDefault(k, 0) + 1);
                }
            }
            for (Integer value : map.values()) {
                res = Math.max(res, value);
            }
        }
        return res;
    }
}
