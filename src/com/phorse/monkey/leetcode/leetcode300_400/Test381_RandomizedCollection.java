package com.phorse.monkey.leetcode.leetcode300_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author luoxusheng 2020/10/31 17:08
 * @version 1.0.0
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 *
 * 注意: 允许出现重复元素。
 *
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * 示例:
 *
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 *
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * key: 1
 * value: 0
 * collection.insert(1);
 *
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * key:1
 * val:0,1
 * collection.insert(1);
 *
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * key:1     2
 * val:0,1    2
 * collection.insert(2);
 *
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 *
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 * key: 1  2
 * val: 0  1
 *
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test381_RandomizedCollection {

    ArrayList<Integer> list;
    HashMap<Integer, Set<Integer>> map;

    /** Initialize your data structure here. */
    public Test381_RandomizedCollection() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        Set<Integer> indexSet = map.get(val);
        if (indexSet == null || indexSet.isEmpty()) {
            HashSet<Integer> idxSet = new HashSet<>();
            idxSet.add(list.size() - 1);
            map.put(val, idxSet);
            return true;
        }
        indexSet.add(list.size() - 1);
        map.put(val, indexSet);
        return false;

    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int delIdx = map.get(val).iterator().next();
        int lastNum = list.get(list.size() - 1);
        list.set(delIdx, lastNum);
        map.get(val).remove(delIdx);
        map.get(lastNum).remove(list.size() - 1);
        if (delIdx < list.size() - 1) {
            map.get(lastNum).add(delIdx);
        }
        if (map.get(val).size() == 0) {
            map.remove(val);
        }
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }

    @Override
    public String toString() {
        return list.toString() + map.toString();
    }

    public static void main(String[] args) {
        Test381_RandomizedCollection obj = new Test381_RandomizedCollection();
        System.out.println(obj.insert(0));
        System.out.println(obj.toString());
        System.out.println(obj.remove(0));
        System.out.println(obj.toString());
        System.out.println(obj.insert(-1));
        System.out.println(obj.toString());
        System.out.println(obj.remove(0));
        System.out.println(obj.toString());
    }
}
