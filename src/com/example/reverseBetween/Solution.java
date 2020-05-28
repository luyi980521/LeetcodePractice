package com.example.reverseBetween;

/**
 * 92. 反转链表 II
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
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

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (m > n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode start = dummy;
        ListNode end = dummy;
        ListNode pre = dummy;

        for (int i = 0; i < m - 1; i++) {
            if (pre.next != null) {
                pre = pre.next;
            }
        }

        for (int i = 0; i < m; i++) {
            if (start.next != null) {
                start = start.next;
            }
        }

        for (int i = 0; i < n; i++) {
            if (end.next != null) {
                end = end.next;
            }
        }

        ListNode next = end.next;
        end.next = null;

        pre.next = reverse(start);

        start.next = next;

        pre = start;
        start = pre.next;
        end = pre.next;

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}