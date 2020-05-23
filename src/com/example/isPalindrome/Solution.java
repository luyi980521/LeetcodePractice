package com.example.isPalindrome;

/**
 * 判断字符串是否为回文串
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