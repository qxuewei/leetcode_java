package 数组;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?favorite=2cktkvj
public class _3_无重复字符的最长子串 {
    // s = "abcabcbb" 3
    public int lengthOfLongestSubstring20221121(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int res = 0;
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.add(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }

    // 暴力
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int res = 0;
        char[] cs = s.toCharArray();
        HashSet<Character> set;
        int left = 0, right = 0;
        for (left = 0; left < cs.length; left++) {
            char cur = cs[left];
            right = left + 1;
            set = new HashSet<>();
            set.add(cur);
            while (right < cs.length) {
                char rightNum = cs[right];
                if (set.contains(rightNum)) {
                    break;
                }
                set.add(rightNum);
                right += 1;
            }
            if (res < set.size()) {
                res = set.size();
            }
        }
        return res;
    }
}
