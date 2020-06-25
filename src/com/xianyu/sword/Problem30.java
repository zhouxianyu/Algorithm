package com.xianyu.sword;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法
 */
public class Problem30 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stackAssist = new Stack<>();


    public void push(int node) {
        stack.push(node);
        if (stackAssist.size() <= 0 || stackAssist.peek() > node) {
            stackAssist.push(node);
        } else {
            stackAssist.push(stackAssist.peek());
        }
    }

    public void pop() {
        stack.pop();
        stackAssist.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stackAssist.peek();
    }

    public static void main(String[] args) {

    }

}
