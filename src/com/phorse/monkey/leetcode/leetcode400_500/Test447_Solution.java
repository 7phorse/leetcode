package com.phorse.monkey.leetcode.leetcode400_500;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定平面上n对互不相同 的点points ，其中 points[i] = [xi, yi] 。回旋镖 是由点(i, j, k) 表示的元组 ，其中i和j之间的距离和i和k之间的距离相等（需要考虑元组的顺序）。
 * <p>
 * 返回平面上所有回旋镖的数量。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 示例 2：
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：points = [[1,1]]
 * 输出：0
 * <p>
 *
 * @author luoxusheng 2021/7/25 14:28
 * @version v1.0.0
 */
public class Test447_Solution {

    /**
     * 解题思路: 两层循环，分别计算所有点到循环点的距离，放置于map中，再进行计算
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int dx = points[i][0] - points[j][0];
                    int dy = points[i][1] - points[j][1];
                    int dis = dx * dx + dy * dy;
                    map.put(dis, map.getOrDefault(dis, 0) + 1);
                }
            }
            for (Integer value : map.values()) {
                if(value >= 2){
                    res += value * (value-1);
                }
            }
        }
        return res;
    }

}
