package com.xianyu.sword;

import com.xianyu.data.TreeNode;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Problem37 {

    String Serialize(TreeNode root) {
        StringBuffer stringBuffer = new StringBuffer();
        Serialize(root, stringBuffer);
        return stringBuffer.toString();
    }

    private void Serialize(TreeNode root, StringBuffer stringBuffer) {
        if (root == null) {
            stringBuffer.append("$,");
            return;
        }
        stringBuffer.append(root.val).append(",");
        Serialize(root.left, stringBuffer);
        Serialize(root.right, stringBuffer);
    }


    TreeNode Deserialize(String str) {
        String[] data = str.split(",");
        return Deserialize(data, new int[]{0});
    }

    private TreeNode Deserialize(String[] vals, int[] index) {
        if (index[0] >= vals.length) {
            return null;
        }
        String val = vals[index[0]];
        index[0]++;
        TreeNode node = null;
        if (val.equals("$")) {
            return null;
        } else {
            int integer = Integer.parseInt(val);
            node = new TreeNode(integer);
            node.left = Deserialize(vals, index);
            node.right = Deserialize(vals, index);
        }
        return node;
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
        String str = new Problem37().Serialize(treeNode1);
        TreeNode node = new Problem37().Deserialize(str);
        System.out.println("");
    }

}
