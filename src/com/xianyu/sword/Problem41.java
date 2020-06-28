package com.xianyu.sword;

import java.util.ArrayList;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Problem41 {

    ArrayList<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (num > list.get(i)) {
                index++;
            }
        }
        list.add(index, num);
    }

    public Double GetMedian() {
        if (list.size() == 0){
            return null;
        }
        if (list.size() % 2 == 0) {
            double sum = list.get(list.size() / 2) + list.get(list.size() / 2 -1);
            return sum / 2;
        } else {
            return Double.valueOf(list.get(list.size() / 2));
        }
    }

    public static void main(String[] args) {
        Problem41 problem41 = new Problem41();
        problem41.Insert(5);
        System.out.println(problem41.GetMedian());
        problem41.Insert(2);
        System.out.println(problem41.GetMedian());
        problem41.Insert(3);
        System.out.println(problem41.GetMedian());
        problem41.Insert(4);
        System.out.println(problem41.GetMedian());
        problem41.Insert(1);
        System.out.println(problem41.GetMedian());
        problem41.Insert(6);
        System.out.println(problem41.GetMedian());
        problem41.Insert(7);
        System.out.println(problem41.GetMedian());
        problem41.Insert(0);
        System.out.println(problem41.GetMedian());
        problem41.Insert(8);
        System.out.println(problem41.GetMedian());
    }

}
