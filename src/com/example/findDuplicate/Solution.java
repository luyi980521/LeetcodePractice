package com.example.findDuplicate;

import java.util.HashMap;
import java.util.Map;

/**
 * 287.寻找重复的数
 * <p>
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 */
class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int num : nums) {
            if (record.containsKey(num)) {
                return num;
            } else {
                record.put(num, 1);
            }
        }
        throw new IllegalArgumentException("can not find duplicate num");
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        Solution solution = new Solution();
        System.out.println(solution.findDuplicate(nums));
    }
}