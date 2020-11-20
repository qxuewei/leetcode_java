package 剑指Offer;

public class _45_把数组排成最小的数 {
    /**
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [10,2]
     * 输出: "102"
     * 示例 2:
     *
     * 输入: [3,30,34,5,9]
     * 输出: "3033459"
     *  
     *
     * 提示:
     *
     * 0 < nums.length <= 100
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public String minNumber(int[] nums) {
        int[] ints = new int[nums.length << 2];
        int idx = 0;
        for (int num : nums) {
            if (num < 10) {
                ints[idx++] = num;
            } else {
                ints[idx++] = num / 10;
                ints[idx++] = num % 10;
            }
        }
        return "";
    }

    private int[] sortBubble(int[] ints) {
        for (int i = ints.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                
            }
        }
        return ints;
    }

}
