package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/3sum/?favorite=2cktkvj
public class _15_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (n < 3) {
            return list;
        }
        Arrays.sort(nums);
        for (int first = 0; first < n; first++) {
            if (nums[first] > 0) {
                return list;
            }
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = 0 - nums[first];
            int second = first + 1;
            int third = n - 1;
            while (second < third) {
                int cur = nums[second] + nums[third];
                if (cur < target) {
                    second += 1;
                } else if (cur > target) {
                    third -= 1;
                } else {
                    ArrayList<Integer> subList = new ArrayList<Integer>(3);
                    subList.add(first);
                    subList.add(second);
                    subList.add(third);
                    list.add(subList);
                    while (second < third && nums[second] == nums[second + 1]) {
                        second += 1;
                    }
                    while (second < third && nums[third] == nums[third - 1]) {
                        third -= 1;
                    }
                    second += 1;
                    third -= 1;
                }
            }
        }
        return list;
    }
}
