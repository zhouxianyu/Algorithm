package com.xianyu.sword;


/**
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Problem23 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode meetNode = isHaveMeet(pHead);
        if (meetNode == null) {
            return null;
        }
        int loopNumber = getLoopNum(meetNode);

        ListNode slowNode = pHead;
        ListNode fastNode = pHead;
        for (int i = 0; i < loopNumber; i++) {
            fastNode = fastNode.next;
        }
        while (slowNode != fastNode) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    private ListNode isHaveMeet(ListNode pHead) {
        ListNode slowNode = pHead;
        ListNode fastNode = pHead.next;
        while (slowNode != null && fastNode != null) {
            if (slowNode == fastNode) {
                return slowNode;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (fastNode != null) {
                fastNode = fastNode.next;
            }
        }
        return null;
    }

    private int getLoopNum(ListNode targetNode) {
        ListNode node = targetNode;
        int loopCount = 1;
        while (node.next != targetNode && node.next != null) {
            node = node.next;
            loopCount++;
        }
        return loopCount;
    }


    public static void main(String[] args) {

    }

}
