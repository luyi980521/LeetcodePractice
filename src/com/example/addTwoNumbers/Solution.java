package com.example.addTwoNumbers;

/**
 * 计算两个倒序链表中 val 的和，相加完成后倒序返回链表头
 */
class Solution {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public static String print(ListNode l) {
            StringBuilder sb = new StringBuilder();
            while (l != null) {
                sb.append(l.val);
                l = l.next;
            }
            return sb.toString();
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int addOne = 0;

        while (l1 != null || l2 != null || addOne != 0) {
            // 获取到每个节点的 val
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + addOne;
            head.next = new ListNode(sum % 10);
            head = head.next;
            addOne = sum / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        l1.next = new ListNode(4);
        l2.next = new ListNode(6);
        System.out.println(ListNode.print(addTwoNumbers(l1, l2)));
    }
}