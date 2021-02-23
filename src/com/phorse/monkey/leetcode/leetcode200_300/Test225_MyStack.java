package com.phorse.monkey.leetcode.leetcode200_300;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 用队列实现栈
 * @Auther: luo
 * @Date: 2020/3/1 00:26
 * <p>
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * <p>
 * 使用两个队列，保持只有一个队列是有数据，做一个交换。
 */
public class Test225_MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public Test225_MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        // push时，q1的数据赋给q2，q1留空。
        queue2 = queue1;
        // q1留空，目的是每次新加入的元素都在q1队列的front
        queue1 = new LinkedList<>();
        // x参数添加至q1，保证再先入队列，实现栈的后进先出。
        queue1.offer(x);
        // 依次将q2的元素取出，放至q1，完成push。
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        Test225_MyStack qs = new Test225_MyStack();
        qs.push(2);
        qs.push(4);
        qs.push(7);
        qs.push(5);
        System.out.println(qs.pop());

    }
}
