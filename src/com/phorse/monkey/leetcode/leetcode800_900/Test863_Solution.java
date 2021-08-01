package com.phorse.monkey.leetcode.leetcode800_900;

import com.phorse.monkey.leetcode.data.TreeNode;
import com.phorse.monkey.utils.TreeUtils;

import java.util.*;

/**
 * 给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值 K 。
 * <p>
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * <p>
 * <p>
 * <p>
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author luoxusheng 2021/7/28 13:37
 * @version v1.0.0
 */
public class Test863_Solution {

    static Map<Integer, TreeNode> parentsMap = new HashMap<>();
    static List<Integer> resultList = new ArrayList<>();

    /**
     * 1.从root开始DFS,标记每个节点的父节点，因为计算距离处理向下搜索还需要想上搜索
     * 2.从target开始，计算距离，若深度距离与k相等，则写入返回list
     *
     * from作用：避免在计算距离时的冲突
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 标记所有节点的父节点
        markParentNodeMap(root);
        // 从target出发寻找距离为k的节点
        findK(target, null, 0, k);
        return resultList;
    }

    private static void findK(TreeNode node, TreeNode from, int index, int k) {
        if (node == null) {
            return;
        }
        if (index == k) {
            resultList.add(node.val);
            return;
        }
        if (node.left != from) {
            findK(node.left, node, index + 1, k);
        }
        if (node.right != from) {
            findK(node.right, node, index + 1, k);
        }
        if (parentsMap.get(node.val) != from) {
            findK(parentsMap.get(node.val), node, index + 1, k);
        }
    }

    private static void markParentNodeMap(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        if (root.left != null) {
            parentsMap.put(root.left.val, root);
            markParentNodeMap(root.left);
        }
        if (root.right != null) {
            parentsMap.put(root.right.val, root);
            markParentNodeMap(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeUtils.show(root);
        TreeNode target = root.left;
        TreeUtils.show(target);
        List<Integer> integers = distanceK(root, target, 2);
        System.out.println(integers);
    }

}
