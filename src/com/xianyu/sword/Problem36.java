package com.xianyu.sword;

import com.xianyu.data.TreeNode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Problem36 {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode linkedNode = covertCore(pRootOfTree, null);
        ;
        while (linkedNode.left != null) {
            linkedNode = linkedNode.left;
        }
        return linkedNode;
    }

    public TreeNode covertCore(TreeNode pRootOfTree, TreeNode linkedNode) {
        if (pRootOfTree == null) {
            return linkedNode;
        }
        if (pRootOfTree.left != null) {
            linkedNode = covertCore(pRootOfTree.left, linkedNode);
        }
        pRootOfTree.left = linkedNode;
        if (linkedNode != null) {
            linkedNode.right = pRootOfTree;
        }
        linkedNode = pRootOfTree;
        if (pRootOfTree.right != null) {
            linkedNode = covertCore(pRootOfTree.right, linkedNode);
        }
        return linkedNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(14);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(8);
        TreeNode treeNode6 = new TreeNode(12);
        TreeNode treeNode7 = new TreeNode(16);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        System.out.println(new Problem36().Convert(treeNode1));


    }

}
