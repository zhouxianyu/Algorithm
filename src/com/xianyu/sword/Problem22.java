package com.xianyu.sword;

import com.xianyu.data.ListNode;

public class Problem22 {


    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }
        ListNode ahead = head;
        ListNode behind = head;
        for (int i = 0; i < k - 1; i++) {
            if (behind.next == null) {
                return null;
            } else {
                behind = behind.next;
            }
        }
        while (behind.next != null) {
            behind = behind.next;
            ahead = ahead.next;
        }
        return ahead;
    }

    public static void main(String[] args) {
        Problem22 solution = new Problem22();
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        System.out.println(solution.FindKthToTail(listNode, 2).val == 3);

        System.out.println(solution.FindKthToTail(listNode, 3).val == 2);
        System.out.println(solution.FindKthToTail(listNode, 4) == null);
    }

}
