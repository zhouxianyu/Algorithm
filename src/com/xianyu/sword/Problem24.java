package com.xianyu.sword;

import com.xianyu.data.ListNode;
import com.xianyu.creator.ListNodeCreator;

public class Problem24 {


    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode target = head;
        ListNode reverseNode = null;
        while (target != null) {
            ListNode next = target.next;
            if (next == null) {
                reverseNode = target;
            }
            target.next = pre;

            pre = target;
            target = next;
        }
        return reverseNode;
    }


    public static void main(String[] args) {
        ListNode node =  ListNodeCreator.createListNode(new int[]{1, 2, 4, 4, 5, 6, 7, 8});
        ListNode reverse = new Problem24().ReverseList(node);
        System.out.println(node);
    }

}
