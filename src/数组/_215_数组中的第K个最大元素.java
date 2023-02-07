package 数组;

// https://leetcode.cn/problems/kth-largest-element-in-an-array/?favorite=2cktkvj
public class _215_数组中的第K个最大元素 {
    public int findMaxK(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        return nums[nums.length - k];
    }

    public void swap(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}
