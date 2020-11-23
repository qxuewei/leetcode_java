package 剑指Offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        sortBubble(nums);
        StringBuilder buffer = new StringBuilder();
        for (int i : nums) {
            buffer.append(i);
        }
        return buffer.toString();
    }

    // 冒泡排序
    private void sortBubble(int[] ints) {
        for (int i = ints.length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (cmp(ints[j-1],ints[j]) > 0) {
                    swap(ints,j,j-1);
                }
            }
        }
    }

    private void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    private int cmp(int scr, int target) {
        return (String.valueOf(scr) + target).compareTo(String.valueOf(target) + scr);
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,9,0,0,99,67,2,0,4,8};
        String s = new _45_把数组排成最小的数().minNumber(test);
        System.out.println(s);
    }

}
