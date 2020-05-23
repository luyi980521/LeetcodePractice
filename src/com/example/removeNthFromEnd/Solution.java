package com.example.removeNthFromEnd;

/**
 * 删除链表的倒数第 N 个节点
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