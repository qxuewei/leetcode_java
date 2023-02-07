package 双指针;
// https://leetcode.cn/problems/trapping-rain-water/?favorite=2cktkvj
public class _42_接雨水 {
    public int trap20230104(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int l = 0;
        int r = n - 1;
        int maxL = 0;
        int maxR = 0;
        int res = 0;
        while (l < r) {
            maxL = Math.max(maxL, height[l]);
            maxR = Math.max(maxR, height[r]);
            if (maxL < maxR) {
                res += maxL - height[l++];
            } else {
                res += maxR - height[r--];
            }
        }
        return res;
    }
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int n = height.length;
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int cur = height[i];
            int l = i - 1, r = i + 1;
            int maxL = height[l];
            int maxR = height[r];
            while (l >= 0) {
                maxL = Math.max(maxL, height[l]);
                l--;
            }
            while (r <= n - 1) {
                maxR = Math.max(maxR, height[r]);
                r++;
            }
            int curTrap = Math.min(maxL, maxR) - cur;
            if (curTrap > 0) {
                res += curTrap;
            }
        }
        return res;
    }
}
