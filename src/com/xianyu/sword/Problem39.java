package com.xianyu.sword;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Problem39 {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int target = array[0];
        int numbers = 1;
        for (int i = 1; i < array.length; i++) {
            if (numbers == 0) {
                target = array[i];
                numbers++;
            } else if (target != array[i]) {
                numbers--;
            } else {
                numbers++;
            }
        }
        if (checkHalf(array, target)) {
            return target;
        } else {
            return 0;
        }
    }

    public boolean checkHalf(int[] array, int target) {
        int numbers = 0;
        for (int num : array) {
            if (num == target) {
                numbers++;
            }
        }
        return numbers * 2 > array.length;
    }

    public static void main(String[] args) {

    }

}
