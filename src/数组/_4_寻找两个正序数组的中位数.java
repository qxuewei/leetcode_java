package 数组;
// https://leetcode.cn/problems/median-of-two-sorted-arrays/?favorite=2cktkvj
public class _4_寻找两个正序数组的中位数 {
    /*
    12345 - 2
    123456 - 2/3
     */



    // 先合并数组，再找中位数
    public static double middle(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;
        int[] nums = new int[totalLength];
        int indexM = 0, indexN = 0;
        int index = 0;

        while (indexM < m && indexN < n) {
            if (nums1[indexM] < nums2[indexN]) {
                nums[index++] = nums1[indexM++];
            } else {
                nums[index++] = nums2[indexN++];
            }
        }

        while (indexM < m) {
            nums[index++] = nums1[indexM++];
        }

        while (indexN < n) {
            nums[index++] = nums2[indexN++];
        }
        if (totalLength % 2 != 0) {
            // 奇数
            return nums[(totalLength - 1) / 2];
        } else {
            return (nums[(totalLength - 1) / 2] + nums[(totalLength - 1) / 2 + 1]) / 2.0;
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println( middle(nums1, nums2) );
    }

}
