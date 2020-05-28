package com.example.isPalindrome;

/**
 * 125. 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();

        // 判断
        while (left < right) {
            while (!Character.isLetterOrDigit(chars[left]) && left < right) {
                left++;
            }

            while (!Character.isLetterOrDigit(chars[right]) && left < right) {
                right--;
            }

            if ((int) Character.toLowerCase(chars[left])
                    != (int) Character.toLowerCase(chars[right])) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(s));
    }
}