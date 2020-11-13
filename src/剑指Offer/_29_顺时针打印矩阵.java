package 剑指Offer;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 剑指Offer
 * @date 2020/11/12 下午4:09
 */
public class _29_顺时针打印矩阵 {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     *
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *  
     *
     * 限制：
     *
     * 0 <= matrix.length <= 100
     * 0 <= matrix[i].length <= 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];

        while (l <= r && t <= b) {
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            for (int i = t + 1; i <= b ; i++) {
                res[x++] = matrix[i][r];
            }
            if (l < r && t < b) {
                for (int i = r - 1; i > l ; i--) {
                    res[x++] = matrix[b][i];
                }
                for (int i = b; i > t ; i--) {
                    res[x++] = matrix[i][l];
                }
            }
            l++;
            r--;
            t++;
            b--;
        }

        return res;
    }

}
