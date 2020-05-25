package com.example.minWindow;

/**
 * 在字符串 s 中找出包含字符串 t 中全部字母的最小字符串
 */
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.equals("")
                || t == null || t.equals("")
                || s.length() < t.length()) {
            return null;
        }

        // 字符频数数组
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        int[] winFreq = new int[128];
        int[] tFreq = new int[128];
        for (char c : charArrayT) {
            tFreq[c]++;
        }

        // 滑动窗口中包含多少 t 中的字符，对应字符频率超过不重复计算
        int distance = 0;
        int minLen = s.length() + 1;
        int begin = 0;

        int left = 0;
        int right = 0;

        // [left, right)
        while (right < s.length()) {
            if (tFreq[charArrayS[right]] == 0) {
                right++;
                continue;
            }

            if (winFreq[charArrayS[right]] < tFreq[charArrayS[right]]) {
                distance++;
            }
            winFreq[charArrayS[right]]++;
            right++;

            while (distance == t.length()) {

                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }

                if (tFreq[charArrayS[left]] == 0) {
                    left++;
                    continue;
                }

                if (winFreq[charArrayS[left]] < tFreq[charArrayS[left]]) {
                    distance--;
                }
                winFreq[charArrayS[left]]--;
                left++;
            }
        }

        if (minLen == s.length() + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }
}