package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/permutations/?favorite=2cktkvj
public class _46_全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        LinkedList<Integer> set = new LinkedList<>();
        _permute(nums, res, set);
        return res;
    }

    private void _permute(int[] nums, List<List<Integer>> res, LinkedList<Integer> set) {
        if (set.size() == nums.length) {
            res.add(new ArrayList<>(set));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            if (set.contains(curNum)) {
                continue;
            }
            set.add(curNum);
            _permute(nums, res, set);
            set.remove(set.size() - 1);
        }
    }
}
