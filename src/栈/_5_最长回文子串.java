package 栈;
// https://leetcode.cn/problems/longest-palindromic-substring/description/?favorite=2cktkvj
public class _5_最长回文子串 {
    // "babad"  "abba" "aabb"
    public String longestPalindrome(String s) {
        String res = "";
        if (s == null || s.length() < 2) {
            return res;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = maxLength(s, i, i);
            int l2 = maxLength(s, i, i + 1);
            int curL = Math.max(l1, l2);
            if (curL > right - left) {
                left = i - (curL - 1) / 2;
                right = i + curL / 2;
            }
        }
        return s.substring(left, right);
    }

    private int maxLength(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i -= 1;
            j += 1;
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
         String test = "babad";
//        System.out.println(longestPalindrome(test));

    }
}
