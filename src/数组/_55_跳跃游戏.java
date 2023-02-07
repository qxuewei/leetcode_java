package 数组;
// https://leetcode.cn/problems/jump-game/description/?favorite=2cktkvj&orderBy=most_votes
public class _55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int targetIndex = n - 1;
        int mostIndex = 0;
        for (int i = 0; i < n; i++) {
            if (i <= mostIndex) {
                mostIndex = Math.max(mostIndex, i + nums[i]);
                if (mostIndex >= targetIndex) {
                    return true;
                }
            }
        }
        return false;
    }
}
