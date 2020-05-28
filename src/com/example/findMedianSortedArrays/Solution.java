package com.example.findMedianSortedArrays;

/**
 * 4. 寻找两个正序数组的中位数
 * <p>
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        if (sum % 2 == 0) {
            return ((double) findKth(nums1, 0, nums2, 0, sum / 2)
                    + findKth(nums1, 0, nums2, 0, sum / 2 + 1)) / 2;
        }
        return findKth(nums1, 0, nums2, 0, (sum + 1) / 2);
    }

    private int findKth(int[] nums1, int left1, int[] nums2, int left2, int k) {
        if (left1 >= nums1.length) return nums2[left2 + k - 1];
        if (left2 >= nums2.length) return nums1[left1 + k - 1];
        if (k == 1) return Math.min(nums1[left1], nums2[left2]);
        int mid1 = left1 + k / 2 - 1 < nums1.length ?
                nums1[left1 + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = left2 + k / 2 - 1 < nums2.length ?
                nums2[left2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (mid1 <= mid2) {
            return findKth(nums1, left1 + k / 2, nums2, left2, k - k / 2);
        }
        return findKth(nums1, left1, nums2, left2 + k / 2, k - k / 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14};
        int[] arr2 = new int[]{2, 4, 6, 8, 10};
        System.out.println(solution.findMedianSortedArrays(arr1, arr2));
    }
}