package 栈;
// https://leetcode.cn/problems/climbing-stairs/description/?favorite=2cktkvj
public class _70_爬楼梯 {

    // 滚动数组
    public int climbStairs20221207(int n) {
        int d = 0, p = 0, r = 1;
        for (int i = 1; i <= n ; i++) {
            d = p;
            p = r;
            r = d + p;
        }
        return r;
    }

    // 动态规划
    public int climbStairs20221207_2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
