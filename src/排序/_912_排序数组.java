package 排序;

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


    private int cmp(int v1, int v2) {
        return v1 - v2;
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
