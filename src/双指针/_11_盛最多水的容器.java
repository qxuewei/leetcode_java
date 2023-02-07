package 双指针;
// https://leetcode.cn/problems/container-with-most-water/description/?favorite=2cktkvj
public class _11_盛最多水的容器 {
    public int maxArea(int[] height) {
        int res = 0;
        if (height.length == 0) {
            return res;
        }
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                res = Math.max(res, (right - left) * height[left]);
                left += 1;
            } else {
                res = Math.max(res, (right - left) * height[right]);
                right -= 1;
            }
        }
        return res;
    }
}
