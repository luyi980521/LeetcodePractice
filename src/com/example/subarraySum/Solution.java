package com.example.subarraySum;

/**
 * 给出一个数组，统计数组中有多少个连续子序列的和为 k
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        Solution solution = new Solution();
        System.out.println(solution.subarraySum(arr, 2));
    }
}