package 数组;
// https://leetcode.cn/problems/house-robber/?favorite=2cktkvj
public class _198_打家劫舍 {
    // 动态规划
    // 转移方程： dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[length - 1];
    }

    public int rob20221229(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int lastMax = nums[0];
        int max = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = max;
            max = Math.max(max, lastMax + nums[i]);
            lastMax = temp;
        }
        return max;
    }
}
