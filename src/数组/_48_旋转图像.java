package 数组;
// https://leetcode.cn/problems/rotate-image/?favorite=2cktkvj
public class _48_旋转图像 {
    // 超出1f没做出
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0 || n == 1) {
            return;
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
//                int tmp = matrix[i][j];
//                matrix[i][j] = matrix[n - 1 - j][i];
//                matrix[n - 1 - j][i] = matrix[n - 1 - j][n - 1 - i];
            }
        }
    }
}
