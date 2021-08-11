package 数组;

public class _59_螺旋矩阵II {

    /**
     * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：[[1]]
     *  
     *
     * 提示：
     *
     * 1 <= n <= 20
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1, target = n * n;
        while (num <= target) {
            // 左 -> 右
            for (int i = l; i <= r; i++) {
                res[t][i] = num++;
            }
            t++;
            // 上 -> 下
            for (int i = t; i <= b; i++) {
                res[i][r] = num++;
            }
            r--;
            // 右 -> 左
            for (int i = r; i >= l ; i--) {
                res[b][i] = num++;
            }
            b--;
            // 下 -> 上
            for (int i = b; i >= t ; i--) {
                res[i][l] = num++;
            }
            l++;
        }
        return res;
    }
}
