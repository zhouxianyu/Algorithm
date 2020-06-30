package com.xianyu.sword;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Problem41 {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
        if (num == null) {
            return;
        }
        if (((maxHeap.size() + minHeap.size()) & 1) == 0) {
            if (maxHeap.size() > 0 && maxHeap.peek() > num) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {
            if (minHeap.size() > 0 && minHeap.peek() < num) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            return null;
        }
        if (((minHeap.size() + maxHeap.size()) & 1) == 0) {
            double sum = minHeap.peek() + maxHeap.peek();
            return sum / 2;
        } else {
            double value = minHeap.peek()/2.0;
            return Double.valueOf(value);
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
