package 数组;
// https://leetcode.cn/problems/number-of-islands/?favorite=2cktkvj
public class _200_岛屿数量 {
    public int numInLans(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // DFS 把相邻的 1 改为 0
    private void dfs(char[][] grid, int m, int n) {
        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length || grid[m][n] == '0') {
            return;
        }
        grid[m][n] = '0';
        dfs(grid, m - 1, n);
        dfs(grid, m + 1, n);
        dfs(grid, m, n - 1);
        dfs(grid, m, n + 1);
    }
}
