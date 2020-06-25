package com.xianyu.sword;

import com.xianyu.data.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Problem34 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        findPathCore(root, target, 0, result,stack);
        return result;
    }

    public void findPathCore(TreeNode root, int target, int current, ArrayList<ArrayList<Integer>> result, Stack<Integer> stack) {
        current = current + root.val;
        if (current > target) {
            return;
        }
        stack.push(root.val);
        boolean isLeaf = root.left == null && root.right == null;
        if (isLeaf && current == target) {
            ArrayList<Integer> path = new ArrayList<>(stack);
            result.add(path);
            stack.pop();
            return;
        }
        if (root.left != null) {
            findPathCore(root.left, target, current, result, stack);
        }
        if (root.right != null) {
            findPathCore(root.right, target, current, result, stack);
        }
        stack.pop();
    }

    public static void main(String[] args) {

    }

}
