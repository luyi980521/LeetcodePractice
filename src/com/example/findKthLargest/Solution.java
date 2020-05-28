package com.example.findKthLargest;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
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