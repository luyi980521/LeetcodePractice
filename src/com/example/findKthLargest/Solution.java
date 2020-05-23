package com.example.findKthLargest;

import java.util.PriorityQueue;

/**
 * 查找数组中第 k 大的元素
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        int[] res = new int[nums.length];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i] = queue.poll();
            i++;
        }
        return res[res.length - k];
    }

    public static void main(String[] args) {
        int[] arr = {12, 52, 8, 46, 18};
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(arr, 5));
    }
}