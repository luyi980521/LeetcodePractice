package com.example.removeNthFromEnd;

/**
 * 19. 删除链表的倒数第 N 个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
class Solution {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pre = new ListNode(0);
        ListNode start, end;

        pre.next = head;
        start = pre;
        end = pre;

        for (int i = 0; i < n; i++) {
            start = start.next;
        }

        while (start.next != null) {
            start = start.next;
            end = end.next;
        }

        end.next = end.next.next;
        return pre.next;
    }
}