package 牛客;

/*
描述
输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，子数组最小长度为1。求所有子数组的和的最大值。
数据范围:
1 <= n <= 2\times10^51<=n<=2×10
5

-100 <= a[i] <= 100−100<=a[i]<=100

要求:时间复杂度为 O(n)O(n)，空间复杂度为 O(n)O(n)
进阶:时间复杂度为 O(n)O(n)，空间复杂度为 O(1)O(1)
示例1
输入：
[1,-2,3,10,-4,7,2,-5]
复制
返回值：
18
复制
说明：
经分析可知，输入数组的子数组[3,10,-4,7,2]可以求得最大和为18
示例2
输入：
[2]
复制
返回值：
2
复制
示例3
输入：
[-10]
复制
返回值：
-10

https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=117&tqId=37797&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */

public class _NC19_连续子数组的最大和 {
    /*
    [1,-2,3,10,-4,7,2,-5]
    滑动窗口：
    双指针，快指针一路往前，慢指针紧随其后，遇到比当前最大值大的区间快指针停止，收缩慢指针
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        // 动态规划 dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
        int max = array[0];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            // i 结尾的和最大值
            // 此时 sum = dp[i - 1]
            sum = Math.max(sum + array[i], array[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}
