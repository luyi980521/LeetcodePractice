package com.example.validPalindrome;

/**
 * 验证字符串是否为回文串
 */
class Solution {
    public boolean validPalindrome(String s) {

        int left = 0, right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) == (s.charAt(right))) {

                left++;
                right--;
            } else {
                break;
            }
        }

        return left >= right
                || validPalindrome(s, left + 1, right)
                || validPalindrome(s, left, right - 1);
    }

    private boolean validPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) == (s.charAt(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "cbbcc";
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome(str));
    }
}