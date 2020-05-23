package com.example.reverseKGroup;

/**
 * k 个一组翻转链表
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

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 将 end 向后移动 k 次，并且要保证 end 最终移动到的位置不为空
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            // 检查移动完成之后 end 是否为空
            if (end == null) break;

            ListNode start = pre.next;
            ListNode next = end.next;

            // 将 end 与之后的节点断开连接
            end.next = null;

            // 将 [start, end] 区间的节点进行翻转，
            // 翻转完成后将头节点位于 pre.next 的位置
            pre.next = reverse(start);

            // 翻转成功之后将断开的节点再次连接上
            start.next = next;

            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    /**
     * 将链表进行翻转，翻转完成之后返回链表头节点。
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 如果 cur 为空则返回 头节点
        return pre;
    }
}