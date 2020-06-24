package com.xianyu.sword;

import com.xianyu.data.TreeNode;

public class Problem28 {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return false;
        }
        return isSymmetricalCore(pRoot.left, pRoot.right);

    }

    private boolean isSymmetricalCore(TreeNode pLeft, TreeNode pRight) {
        if (pLeft == null && pRight == null) {
            return true;
        }
        if (pLeft == null || pRight == null) {
            return false;
        }
        if (pLeft.val != pRight.val) {
            return false;
        }
        return isSymmetricalCore(pLeft.left, pRight.right);
    }


    public static void main(String[] args) {

    }

}
