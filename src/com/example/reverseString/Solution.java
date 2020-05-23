package com.example.reverseString;

/**
 * 翻转字符串，使用双指针法
 */
class Solution {
    public void reverseString(char[] s) {
        int ptr1 = 0, ptr2 = s.length - 1;
        while (ptr1 < ptr2) {
            char temp = s[ptr1];
            s[ptr1] = s[ptr2];
            s[ptr2] = temp;
            ptr1++; ptr2--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        Solution solution = new Solution();
        solution.reverseString(s);
    }
}