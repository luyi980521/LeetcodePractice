package com.example.validPalindrome;

/**
 * 680. 验证回文字符串 Ⅱ
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
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