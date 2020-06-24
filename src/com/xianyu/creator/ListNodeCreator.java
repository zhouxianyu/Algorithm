package com.xianyu.creator;

import com.xianyu.asset.ListNode;

public class ListNodeCreator {

    public static ListNode createListNode(int[] vals) {
        if (vals == null || vals.length == 0) {
            return null;
        }
        ListNode head = null;
        ListNode target = null;
        for (int val : vals) {
            if (head == null) {
                head = new ListNode(val);
                target = head;
            } else {
                ListNode next = new ListNode(val);
                target.next = next;
                target = next;
            }
        }
        return head;
    }

}
