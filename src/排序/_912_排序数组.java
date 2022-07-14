package 排序;

import java.util.Random;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 排序
 * @date 2020/10/12 下午5:43
 */
public class _912_排序数组 {
    /**
     * 给你一个整数数组 nums，请你将该数组升序排列。
     *
     * 示例 1：
     * ```
     * 输入：nums = [5,2,3,1]
     * 输出：[1,2,3,5]
     * ```
     * 示例 2：
     * ```
     * 输入：nums = [5,1,1,2,0,0]
     * 输出：[0,0,1,1,2,5]
     * ```
     *
     * 提示：
     * ```
     * 1 <= nums.length <= 50000
     * -50000 <= nums[i] <= 50000
     * ```
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    // 冒泡排序1
    public int[] sortArray1(int[] nums) {
        for (int end = nums.length - 1; end > 0 ; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (nums[begin - 1] > nums[begin]) {
                    int tmp = nums[begin - 1];
                    nums[begin - 1] = nums[begin];
                    nums[begin] = tmp;
                }
            }
        }
        return nums;
    }

    // 冒泡排序2
    public int[] sortArray2(int[] nums) {
        for (int end = nums.length - 1; end > 0 ; end--) {
            boolean sorted = true;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(nums[begin - 1], nums[begin]) > 0) {
                    swap(nums, begin-1,begin);
                    sorted = false;
                }
            }
            if (sorted) break;
        }
        return nums;
    }

    // 冒泡排序3
    public int[] sortArray3(int[] nums) {
        for (int end = nums.length - 1; end > 0 ; end--) {
            int endIndex = end;
            for (int start = 1; start <= end; start++) {
                if (cmp(nums[start - 1], nums[start]) > 0) {
                    swap(nums,start - 1, start);
                    endIndex = start;
                }
            }
        }
        return nums;
    }

    // 冒泡 - 超时
    public void sortArrayBubble1(int[] nums) {
        int count = nums.length;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i - 1 ; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    // 冒泡 - 优化
    public void sortArrayBubble2(int[] nums) {
        int count = nums.length;
        for (int i = 0; i < count; i++) {
            boolean sorted = true;
            for (int j = 0; j < count - i - 1 ; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    // 选择
    public void sortArraySelection(int[] nums) {
        int count = nums.length;
        for (int i = 0; i < count; i++) {
            int minIndex = i;
            for (int j = i + 1; j < count; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(nums, i, minIndex);
            }
        }
    }

    // 插入
    public void sortArrayInsert(int[] nums) {
        int count = nums.length;
        if (count < 2) return;
        for (int i = 1; i < count; i++) {
            int j = i;
            while (j > 0 && nums[j - 1] > nums[j]) {
                swap(nums, j - 1, j);
                j -= 1;
            }
        }
    }

    // 随机快排
    public void sortArrayQuick1(int[] nums) {
        int count = nums.length;
        if (count < 2) return;
        quick1(nums, 0, count - 1);
    }
    private void quick1(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = poivtIndex(nums, left, right);
        quick1(nums, left, index - 1);
        quick1(nums, index + 1, right);
    }
    public int poivtIndex(int[] nums, int left, int right) {
        int random = new Random().nextInt(right - left + 1) + left;
        swap(nums, right, random);
        int key = nums[right];
        int j = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < key) {
                if (i != j) {
                    swap(nums, i, j);
                }
                j += 1;
            }
        }
        swap(nums, j, right);
        return j;
    }


    private int cmp(int v1, int v2) {
        return v1 - v2;
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
