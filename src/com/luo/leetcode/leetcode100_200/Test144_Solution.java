package com.luo.leetcode.leetcode100_200;

import com.luo.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author luoxusheng 2020/10/27 14:22
 * @version 1.0.0
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test144_Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new LinkedList<>();
        while(root!=null){
            TreeNode tmp = root.left;
            if(tmp == null){
                resultList.add(root.val);
                root = root.right;
                continue;
            }
            while(tmp.right!=null && tmp.right!=root){
                tmp = tmp.right;
            }
            if(tmp.right==null){
                resultList.add(root.val);
                tmp.right = root;
                root = root.left;
            } else {
                tmp.right = null;
                root = root.right;
            }
        }
        return resultList;
    }

}
