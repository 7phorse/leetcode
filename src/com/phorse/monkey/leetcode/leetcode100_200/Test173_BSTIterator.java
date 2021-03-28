package com.phorse.monkey.leetcode.leetcode100_200;

import com.phorse.monkey.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 *
 * 你可以假设next()调用总是有效的，也就是说，当调用 next()时，BST 的中序遍历中至少存在一个下一个数字。
 *
 * @author luoxusheng 2021/3/28 16:36
 * @version v1.0.0
 */
public class Test173_BSTIterator {

    private int index;
    private List<Integer> list;

    /**
     * 解题思路：中序遍历，维护数组
     * 1. dfs将树转换为list
     * 2. next: 返回对应数组的值并将指针后移
     * 3. hasNext: 判断当前下标是否小于数组长度，即右侧遍历存在数字（指针不进行移动）
     */
    public Test173_BSTIterator(TreeNode root) {
        index = 0;
        list = inorder(root, new ArrayList<>());
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }

    private List<Integer> inorder(TreeNode root, List<Integer> list){
        if (root == null) {
            return list;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return list;
    }
}
