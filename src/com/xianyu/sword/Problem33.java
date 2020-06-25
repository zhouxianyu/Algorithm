package com.xianyu.sword;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Problem33 {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        int root = sequence[sequence.length - 1];
        int leftIndex = 0;
        for (int i = 0; i < sequence.length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }else {
                leftIndex = i;
            }
        }
        int rightIndex = leftIndex + 1;
        for (int i = rightIndex; i < sequence.length - 1; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        boolean leftTree = true;
        if (leftIndex >= 0) {
            int[] leftSequence = new int[leftIndex + 1];
            System.arraycopy(sequence, 0, leftSequence, 0, leftIndex + 1);
            leftTree = VerifySquenceOfBST(leftSequence);
        }
        boolean rightTree = true;
        if (rightIndex < sequence.length - 1) {
            int[] rightSequence = new int[sequence.length - rightIndex - 1];
            System.arraycopy(sequence, rightIndex, rightSequence, 0, sequence.length - rightIndex - 1);
            rightTree = VerifySquenceOfBST(rightSequence);
        }

        return leftTree && rightTree;
    }

    public static void main(String[] args) {
//        System.out.println(new Problem33().VerifySquenceOfBST(new int[]{5, 7, 6, 9, 11, 10, 8}));
        System.out.println(new Problem33().VerifySquenceOfBST(new int[]{1, 2, 3, 4, 5}));
    }

}
