package 回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/subsets/?favorite=2cktkvj
public class _78_子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        _subsets(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void _subsets(int[] nums, List<List<Integer>> res, ArrayList<Integer> sets, int beginIndex) {
        res.add(new ArrayList<>(sets));
        for (int i = beginIndex; i < nums.length; i++) {
            sets.add(nums[i]);
            _subsets(nums, res, sets, i + 1);
            sets.remove(sets.size() - 1);
        }
    }
}
