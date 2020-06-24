package com.xianyu.sword;

import com.xianyu.asset.ListNode;
import com.xianyu.creator.ListNodeCreator;

public class Problem25 {

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode mergedNode = null;
        if (list1.val <= list2.val) {
            mergedNode = list1;
            mergedNode.next = merge(list1.next, list2);
        } else {
            mergedNode = list2;
            mergedNode.next = merge(list1, list2.next);
        }
        return mergedNode;
    }

    public static void main(String[] args) {
        ListNode list1 = ListNodeCreator.createListNode(new int[]{1, 5, 6, 10});
        ListNode list2 = ListNodeCreator.createListNode(new int[]{2, 4, 8, 9});
        ListNode mergeList = new Problem25().merge(list1, list2);
        System.out.println(mergeList);

    }
}
