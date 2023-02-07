package 数组;

import java.util.Arrays;

// https://leetcode.cn/problems/merge-intervals/description/?favorite=2cktkvj&orderBy=most_votes
public class _56_合并区间 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[2][0];
        }
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (index == -1 || res[index][1] < intervals[i][0]) {
                res[++index] = intervals[i];
            } else {
                res[index][1] = Math.max(intervals[i][1], res[index][1]);
            }
        }
        return Arrays.copyOf(res, index + 1);
    }

}
