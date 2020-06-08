package com.example.sortArray;

/**
 * 912. 排序数组
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = {-4,0,7,4,9,-5,-1,0,-7,-1};
        Solution.sortArray(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int[] sortArray(int[] nums) {
        int n = nums.length;
        int[] arr = sortArray(nums, 0, n - 1);
        return arr;
    }

    private static int[] sortArray(int[] arr, int l, int r) {
        if (l >= r) return arr;
        int p = partition(arr, l, r);
        sortArray(arr, l, p - 1);
        sortArray(arr, p + 1, r);
        return arr;
    }

    private static int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int j = l;
        for (int i = j + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr, ++j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}