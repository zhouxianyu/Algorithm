package com.xianyu.sword;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class Problem31 {

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int maxIndex = pushA.length - 1;
        for (int i = 0; i < popA.length; i++) {
            while (stack.isEmpty() || stack.peek() != popA[i]) {
                if (index <= maxIndex) {
                    stack.push(pushA[index]);
                    index++;
                } else {
                    return false;
                }
            }
            stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new Problem31().IsPopOrder(new int[]{}, new int[]{}));
        System.out.println(new Problem31().IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(new Problem31().IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 4, 1, 2}));
    }

}



