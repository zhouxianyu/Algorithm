package com.xianyu.utils;

public class DataChange {

    public static int partition(int[] data, int start, int end) {
        if (data == null || data.length <= 0 || start < 0 || end >= data.length) {
            throw new IllegalArgumentException("params error");
        }
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (data[i] < data[end]) {
                small++;
                if (small != i) {
                    swap(data, small, i);
                }
            }
        }
        small++;
        swap(data, small, end);
        return small;
    }

    public static void swap(int[] data, int x, int y) {
        int temple = data[x];
        data[x] = data[y];
        data[y] = temple;
    }

}
