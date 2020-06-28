package com.xianyu.sword;

import com.xianyu.utils.DataChange;

import java.util.ArrayList;

public class Problem40 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length <= 0 || k <= 0 || k > input.length) {
            return result;
        }
        int index = DataChange.partition(input, 0, input.length - 1);
        while (index != k - 1) {
            if (index > k - 1) {
                index = DataChange.partition(input, 0, index - 1);
            }
            if (index < k - 1) {
                index = DataChange.partition(input, index + 1, input.length - 1);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    public static void quickSort(int[] data, int start, int end) {
        if (start == end) {
            return;
        }
        int index = DataChange.partition(data, start, end);
        if (index > start) {
            quickSort(data, start, index - 1);
        }
        if (index < end) {
            quickSort(data, index + 1, end);
        }

    }

    public static void main(String[] args) {
        int[] list = {8, 4, 7, 2, 6, 10, 5};
        ArrayList<Integer> result = new Problem40().GetLeastNumbers_Solution(list, 3);

        System.out.println(result);
    }

}
