package com.xianyu.sword;

/**
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Problem35 {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode targetNode = pHead;
        while (targetNode != null) {
            RandomListNode next = targetNode.next;
            RandomListNode fake = new RandomListNode(targetNode.label);
            fake.next = next;
            targetNode.next = fake;
            targetNode = next;
        }

        targetNode = pHead;
        while (targetNode != null) {
            RandomListNode fake = targetNode.next;
            if (targetNode.random != null) {
                fake.random = targetNode.random.next;
            }
            targetNode = fake.next;
        }

        targetNode = pHead;
        RandomListNode targetFakeNode = pHead.next;
        RandomListNode fakeHead = targetFakeNode;
        targetNode.next = targetFakeNode.next;
        targetNode = targetNode.next;
        while (targetNode != null) {
            targetFakeNode.next = targetNode.next;
            targetFakeNode = targetFakeNode.next;
            targetNode.next = targetFakeNode.next;
            targetNode = targetFakeNode.next;
        }

        return fakeHead;
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        System.out.println(new Problem35().Clone(node1));
    }

}
