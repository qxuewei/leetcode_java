package 剑指Offer;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 剑指Offer
 * @date 2020/11/13 下午3:21
 */
public class _51_数组中的逆序对 {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [7,5,6,4]
     * 输出: 5
     *  
     *
     * 限制：
     *
     * 0 <= 数组长度 <= 50000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int reversePairs(int[] nums) {
        int length = nums.length;
        if (length < 2) return 0;
//        int[] copy = new int[length];
//        for (int i = 0; i < length; i++) {
//            copy[i] = nums[i];
//        }
        int[] temp = new int[length];
        return reversePairs(nums, 0, length-1, temp);
    }

    private int reversePairs(int[] copy, int begin, int end, int[] temp) {
        if (begin == end) return 0;
        int mid = (begin + end) / 2;
        int left = reversePairs(copy, begin,mid,temp);
        int right = reversePairs(copy, mid+1,end,temp);
        int merge = merge(copy,begin,mid,end,temp);
        return left + right + merge;
    }

    private int merge(int[] copy, int begin, int mid, int end, int[] temp) {
        for (int i = begin; i <= end; i++) {
            temp[i] = copy[i];
        }
        int res = 0;
        int l = begin, r = mid+1, x = begin;
        while (l <= mid && r <= end) {
            if (temp[l] <= temp[r]) {
                copy[x++] = temp[l++];
            } else {
                copy[x++] = temp[r++];
                res += (mid - l + 1);
            }
        }
        while (l <= mid) {
            copy[x++] = temp[l++];
        }
        while (r <= end) {
            copy[x++] = temp[r++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{5,4,3,2,1,100,200,6,28,66,29};
        int res = new _51_数组中的逆序对().reversePairs(test);
        System.out.println("res=" + res);
        for (int i : test) {
            System.out.print(i + ",");
        }
    }


}
