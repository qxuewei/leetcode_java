package 数组;

public class _69_x的平方根 {
    /**
     * 实现 int sqrt(int x) 函数。
     *
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     *
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * 示例 1:
     *
     * 输入: 4
     * 输出: 2
     * 示例 2:
     *
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sqrtx
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static int mySqrt(int x) {
        if (x < 2) return x;
        int left = 2, right = x / 2;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            int n = x / middle;
            if (middle == n) {
                return middle;
            } else if (middle < n) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int n = 2147395599; // 2147395599 -> 46339
        System.out.println("res = " + mySqrt(n));
    }
}
