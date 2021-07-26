package 数组;

public class _367_有效的完全平方数 {
    /**
     * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
     *
     * 进阶：不要 使用任何内置的库函数，如  sqrt 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：num = 16
     * 输出：true
     * 示例 2：
     *
     * 输入：num = 14
     * 输出：false
     *  
     *
     * 提示：
     *
     * 1 <= num <= 2^31 - 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-perfect-square
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static boolean isPerfectSquare1(int num) {
        if (num < 2) return true;
        long left = 2, right = num / 2;
        while (left <= right) {
            long middle = left + ((right - left) >> 1);
            long n = middle * middle;
            if (n == num) {
                return true;
            } else if (n > num) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }


    public static boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long left = 2, right = num / 2, middle = 0, squared = 0;
        while (left <= right) {
            middle = left + ((right - left) >> 1);
            squared = middle * middle;
            if (num == squared) return true;
            if (squared > num) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("res = " + isPerfectSquare1(808201));
    }
}
