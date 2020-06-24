package com.xianyu.sword;

import com.xianyu.data.TreeNode;

public class Problem27 {

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;

        Mirror(root.left);
        Mirror(root.right);
    }

    public static void main(String[] args) {

    }

}
