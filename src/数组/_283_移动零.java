package 数组;
// https://leetcode.cn/problems/move-zeroes/?favorite=2cktkvj

public class _283_移动零 {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/move-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public void moveZeroes202211205(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
        }
        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public static void moveZeroes(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[left++] = nums[i];
            }
        }
        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
