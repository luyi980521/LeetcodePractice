package com.example.isValid;

import java.util.Stack;

/**
 * 判断传入的括号是否有效
 * 使用栈相关的知识
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();

                if (pop == '(' && c != ')') {
                    return false;
                }

                if (pop == '{' && c != '}') {
                    return false;
                }

                if (pop == '[' && c != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "}";
        Solution solution = new Solution();
        System.out.println(solution.isValid(str));
    }
}