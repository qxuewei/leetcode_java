package 牛客;

import java.util.Random;

/*
有一个整数数组，请你根据快速排序的思路，找出数组中第 k 大的数。

给定一个整数数组 a ,同时给定它的大小n和要找的 k ，请返回第 k 大的数(包括重复的元素，不用去重)，保证答案存在。
要求：时间复杂度 O(nlogn)O(nlogn)，空间复杂度 O(1)O(1)
数据范围：0\le n \le 10^50≤n≤10
5
 ， 1 \le K \le n1≤K≤n，数组中每个元素满足 0 \le val \le 10^90≤val≤10
9

示例1
输入：
[1,3,5,2,2],5,3
复制
返回值：
2
复制
示例2
输入：
[10,10,9,9,8,7,5,6,4,3,4,2],12,3
复制
返回值：
9
复制
说明：
去重后的第3大是8，但本题要求包含重复的元素，不用去重，所以输出9
 */
public class _NC88_寻找第K大 {
    public int findKth(int[] a, int n, int K) {
        qucik(a, 0, n - 1);
        return a[n - K];
    }

    private void qucik(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int povitIndex = povitIndex(nums, left, right);
        qucik(nums, left, povitIndex - 1);
        qucik(nums, povitIndex + 1, right);
    }

    private int povitIndex(int[] nums, int left, int right) {
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, randomIndex, right);
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] < nums[right]) {
                if (i != j) {
                    swap(nums, i, j);
                }
                i += 1;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
