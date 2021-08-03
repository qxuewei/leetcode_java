package 数组;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class _977_有序数组的平方 {
    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     * 示例 2：
     *
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 已按 非递减顺序 排序
     *  
     *
     * 进阶：
     *
     * 请你设计时间复杂度为 O(n) 的算法解决本问题
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */

    /// 直接遍历后排序
    public static int[] sortedSquares1(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }

    /// 快慢指针
    public static int[] sortedSquares3(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1, index = nums.length - 1;
        while (index >= 0) {
            int sLeft = nums[left] * nums[left];
            int sRight = nums[right] * nums[right];
            if (sLeft > sRight) {
                res[index] = sLeft;
                left++;
            } else {
                res[index] = sRight;
                right--;
            }
            index --;
        }
        return res;
    }

    /// 二分法1 - 归并 [-4,-1,0,3,10]
    public static int[] sortedSquares2(int[] nums) {
        // 查找最后一个负数
        int negativeIdx = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num >= 0) {
                break;
            } else {
                negativeIdx = i;
            }
        }
        // 找到最后一个负数坐标 negativeIdx
        int idx = 0, i = negativeIdx, j = negativeIdx + 1;
        int[] res = new int[n];
        while (i >= 0 || j < n) {
            // [0, negativeIdx] [negativeIdx + 1, nums.length)
            if (i < 0) {
                res[idx] = nums[j] * nums[j];
                j++;
            } else if (j == n) {
                res[idx] = nums[i] * nums[i];
                i--;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                res[idx] = nums[i] * nums[i];
                --i;
            } else {
                res[idx] = nums[j] * nums[j];
                ++j;
            }
            idx++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
        int[] res = sortedSquares2(nums);
        for (int o : res) {
            System.out.printf(o + " ");
        }
    }
}
