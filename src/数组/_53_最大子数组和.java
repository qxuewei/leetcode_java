package 数组;
// https://leetcode.cn/problems/maximum-subarray/?favorite=2cktkvj
public class _53_最大子数组和 {
    // nums = [-2,1,-3,4,-1,2,1,-5,4]  - 6
    // 动态规划： dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
    public int maxArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
