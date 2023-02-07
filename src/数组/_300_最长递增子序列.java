package 数组;
// https://leetcode.cn/problems/longest-increasing-subsequence/?favorite=2cktkvj
public class _300_最长递增子序列 {
    public int lengthMax(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
