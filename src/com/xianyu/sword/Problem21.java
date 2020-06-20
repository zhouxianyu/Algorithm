package com.xianyu.sword;

import com.xianyu.asset.Assets;

/**
 * 题目：调整数组顺序使奇数位于偶数前面
 */
public class Problem21 {

    public void reOrderArray(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        int pre = start;
        int back = end;


        while (pre < back) {
            while (pre < end && (array[pre] & 0x1) != 0) {
                pre++;
            }
            while (back > start && (array[back] & 0x1) == 0) {
                back--;
            }
            if (pre < back) {
                int temp = array[pre];
                array[pre] = array[back];
                array[back] = temp;
            }
        }

    }

    /**
     * 不改变顺序
     *
     * @param array
     */
    public void reOrderArray2(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if ((array[j] & 0x1) != 0 && (array[j - 1] & 0x1) == 0) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        Problem21 solution = new Problem21();

        int[] input1 = new int[]{1, 2, 2, 3, 3};
        solution.reOrderArray2(input1);
        System.out.println(Assets.assetsArrayEquals(input1, new int[]{1, 3, 3, 2, 2}));

        int[] input2 = null;
        solution.reOrderArray2(input2);
        System.out.println(Assets.assetsArrayEquals(input2, null));

        int[] input3 = new int[]{1};
        solution.reOrderArray2(input3);
        System.out.println(Assets.assetsArrayEquals(input3, new int[]{1}));

        int[] input4 = new int[]{1, 3, 5};
        solution.reOrderArray2(null);
        System.out.println(Assets.assetsArrayEquals(input4, new int[]{1, 3, 5}));
    }

}
